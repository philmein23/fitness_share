package com.philnguyen.fitness_share.service;

import com.philnguyen.fitness_share.dto.ExerciseDto;
import com.philnguyen.fitness_share.model.Exercise;
import com.philnguyen.fitness_share.repository.ExerciseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Transactional
    public List<Exercise> findAllExercises() {
        return StreamSupport.stream(exerciseRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Transactional
    public Exercise addNewExercise(String exerciseName, String description, Integer difficulty) {
        Exercise exercise = new Exercise();
        exercise.setExerciseName(exerciseName);
        exercise.setDescription(description);
        exercise.setDifficulty(difficulty);
        return exerciseRepository.save(exercise);
    }

    @Transactional
    public Exercise updateExercise(ExerciseDto updatedExercise, Long id) {
        return exerciseRepository.findById(id).map(exercise -> {
            exercise.setExerciseName(updatedExercise.getExerciseName());
            exercise.setDescription(updatedExercise.getDescription());
            exercise.setDifficulty(updatedExercise.getDifficulty());

            return exerciseRepository.save(exercise);
        }).orElseGet(() -> {
            Exercise exercise = new Exercise();
            exercise.setExerciseId(id);
            return exerciseRepository.save(exercise);
        });
    }

    @Transactional
    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }


    @Transactional
    public List<Exercise> findExerciseByName(String exerciseName) {
        return exerciseRepository.findExerciseByName(exerciseName);
    }

}
