package com.philnguyen.fitness_share.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ExerciseDto {
    @JsonProperty("exercise_name")
    private String exerciseName;
    @JsonProperty("targeted_muscles")
    private List<MuscleDto> targetedMuscles;
    private String description;
    private Integer difficulty;
}
