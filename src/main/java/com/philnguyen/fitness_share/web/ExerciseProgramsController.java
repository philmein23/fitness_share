package com.philnguyen.fitness_share.web;

import com.philnguyen.fitness_share.dto.ExerciseProgramDto;
import com.philnguyen.fitness_share.model.ExerciseProgram;
import com.philnguyen.fitness_share.service.ExerciseProgramService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExerciseProgramsController {
    private final ExerciseProgramService exerciseProgramService;

    public ExerciseProgramsController(ExerciseProgramService exerciseProgramService) {
        this.exerciseProgramService = exerciseProgramService;
    }

    @PostMapping("/programs")
    public ExerciseProgram createNewExerciseProgram(@RequestBody ExerciseProgramDto exerciseProgramDto) {
        return exerciseProgramService.createExerciseProgram(exerciseProgramDto);
    }
}
