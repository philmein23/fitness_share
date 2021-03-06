package com.philnguyen.fitness_share.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.philnguyen.fitness_share.model.Exercise;
import lombok.Data;

import java.util.List;

@Data
public class ExerciseDto {

    @JsonProperty("exercise_id")
    private Long exerciseId;
    @JsonProperty("exercise_name")
    private String exerciseName;
    @JsonProperty("targeted_muscles")
    private List<MuscleDto> targetedMuscles;
    private String description;
    private String difficulty;
}
