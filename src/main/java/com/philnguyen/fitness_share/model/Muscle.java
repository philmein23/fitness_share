package com.philnguyen.fitness_share.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Muscle {
    @Id
    private Long muscleId;
    @JsonProperty("muscle_name")
    private String muscleName;
}
