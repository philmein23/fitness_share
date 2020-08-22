package com.philnguyen.fitness_share.web;

import com.philnguyen.fitness_share.dto.ExerciseProgramDto;
import com.philnguyen.fitness_share.model.ExerciseProgram;
import com.philnguyen.fitness_share.service.ExerciseProgramService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/programs")
    public List<ExerciseProgram> findAllExercisePrograms() {
        System.out.println("GET - PROGRAMS");
        return exerciseProgramService.findAllExercisePrograms();
    }

    @PutMapping("/programs/{programId}")
    public ExerciseProgram updateExerciseProgram(@PathVariable Long programId,  @RequestBody ExerciseProgramDto exerciseProgramDto) {
        return exerciseProgramService.updateExerciseProgram(exerciseProgramDto, programId);
    }

    @DeleteMapping("/programs/{programId}")
    public void deleteExerciseProgram(@PathVariable Long programId) {
        exerciseProgramService.deleteExerciseProgram(programId);
    }
}
