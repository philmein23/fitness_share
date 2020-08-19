package com.philnguyen.fitness_share.service;

import com.philnguyen.fitness_share.dto.ExerciseDto;
import com.philnguyen.fitness_share.dto.ExerciseProgramDto;
import com.philnguyen.fitness_share.dto.MuscleDto;
import com.philnguyen.fitness_share.model.Exercise;
import com.philnguyen.fitness_share.model.ExerciseProgram;
import com.philnguyen.fitness_share.model.Muscle;
import com.philnguyen.fitness_share.repository.ExerciseProgramRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ExerciseProgramService {
    private final ExerciseProgramRepository exerciseProgramRepository;

    public ExerciseProgramService(ExerciseProgramRepository exerciseProgramRepository) {
        this.exerciseProgramRepository = exerciseProgramRepository;
    }

    @Transactional
    public List<ExerciseProgram> findAllExercisePrograms() {
        return StreamSupport
                .stream(exerciseProgramRepository
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional
    public ExerciseProgram createExerciseProgram(ExerciseProgramDto exerciseProgramDto) {
        ExerciseProgram newExerciseProgram = new ExerciseProgram();
        newExerciseProgram.setProgramName(exerciseProgramDto.getProgramName());

        exerciseProgramDto
                .getExercises()
                .stream()
                .forEach((ExerciseDto exerciseDto) -> {
                    Exercise e = new Exercise();
                    e.setExerciseName(exerciseDto.getExerciseName());
                    e.setDifficulty(exerciseDto.getDifficulty());
                    e.setDescription(exerciseDto.getDescription());

                    exerciseDto
                            .getTargetedMuscles()
                            .stream()
                            .forEach((MuscleDto muscleDto) -> {
                                Muscle m = new Muscle();
                                m.setMuscleName(muscleDto.getMuscleName());
                                e.addTargetedMuscle(m);
                            });

                    newExerciseProgram.addExercise(e);
                });

        return exerciseProgramRepository.save(newExerciseProgram);
    }

    @Transactional
    public ExerciseProgram updateExerciseProgram(ExerciseProgramDto exerciseProgramDto, Long programId) {
        return exerciseProgramRepository
                .findById(programId)
                .map(program -> {
                    program.setProgramName(exerciseProgramDto.getProgramName());

                    List<ExerciseDto> exerciseDtos = exerciseProgramDto
                            .getExercises()
                            .stream()
                            .collect(Collectors.toList());
                    HashSet<MuscleDto> muscleDtos = new HashSet<>();

                    exerciseDtos
                            .forEach(exerciseDto -> {
                                muscleDtos.addAll(exerciseDto
                                        .getTargetedMuscles());
                            });
                    program
                            .getExercises()
                            .forEach(exercise -> {
                                for (ExerciseDto e : exerciseDtos) {
                                    if (exercise
                                            .getExerciseId()
                                            .equals(e.getExerciseId())) {
                                        exercise.setExerciseName(e.getExerciseName());
                                        exercise.setDescription(e.getDescription());
                                        exercise.setDifficulty(e.getDifficulty());
                                    }
                                }
                                exercise
                                        .getTargetedMuscles()
                                        .forEach(muscle -> {
                                            for (MuscleDto m : muscleDtos) {
                                                if (muscle
                                                        .getMuscleId()
                                                        .equals(m.getMuscleId())) {
                                                    muscle.setMuscleName(m.getMuscleName());
                                                }
                                            }
                                        });

                            });


                    return exerciseProgramRepository.save(program);
                })
                .orElse(null);
    }

    @Transactional
    public void deleteExerciseProgram(Long programId) {
        exerciseProgramRepository.deleteById(programId);
    }
}
