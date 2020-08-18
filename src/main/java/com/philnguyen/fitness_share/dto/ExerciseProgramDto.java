package com.philnguyen.fitness_share.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.philnguyen.fitness_share.model.Exercise;
import lombok.Data;

import java.util.List;

@Data
public class ExerciseProgramDto {
    @JsonProperty("program_name")
    private String programName;
    private List<ExerciseDto> exercises;
}
