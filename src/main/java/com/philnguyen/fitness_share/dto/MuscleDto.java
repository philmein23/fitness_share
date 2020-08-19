package com.philnguyen.fitness_share.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MuscleDto {
    @JsonProperty("muscle_id")
    private Long muscleId;
    @JsonProperty("muscle_name")
    private String muscleName;
}
