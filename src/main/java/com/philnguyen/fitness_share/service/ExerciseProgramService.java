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
                                System.out.print(e);
                            });

                    newExerciseProgram.addExercise(e);
                });

        return exerciseProgramRepository.save(newExerciseProgram);
    }
}
