package com.philnguyen.fitness_share.web;

import com.philnguyen.fitness_share.dto.ExerciseDto;
import com.philnguyen.fitness_share.model.Exercise;
import com.philnguyen.fitness_share.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExercisesController {
    private final ExerciseService exerciseService;

    public ExercisesController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/exercises")
   public List<Exercise> findAllExercises() {
        return exerciseService.findAllExercises();
    }

    @GetMapping("/exercises/{exerciseName}")
    public List<Exercise> findExerciseByName(@PathVariable String exerciseName) {
        return exerciseService.findExerciseByName(exerciseName);
    }

    @PostMapping("/exercises")
    public Exercise addNewExercise(@RequestBody ExerciseDto newExercise) {
        return exerciseService.addNewExercise(newExercise.getExerciseName(), newExercise.getDescription(), newExercise.getDifficulty());
    }

    @PutMapping("/exercises/{id}")
    public Exercise updateExercise(@RequestBody ExerciseDto updatedExercise, @PathVariable Long id) {
        return exerciseService.updateExercise(updatedExercise, id);
    }

    @DeleteMapping("/exercises/{id}")
    public void deleteExercise(Long id) {
        exerciseService.deleteExercise(id);
    }

}
