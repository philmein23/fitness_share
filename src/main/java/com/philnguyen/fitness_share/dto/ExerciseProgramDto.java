package com.philnguyen.fitness_share.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ExerciseProgramDto {
    @JsonProperty("program_name")
    private String programName;
    private List<ExerciseDto> exercises;
}
