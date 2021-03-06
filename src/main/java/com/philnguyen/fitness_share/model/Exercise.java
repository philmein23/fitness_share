package com.philnguyen.fitness_share.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {

    @Id
    private Long exerciseId;
    @JsonProperty("exercise_name")
    private String exerciseName;
    private String description;

    private String difficulty;
    @JsonProperty("targeted_muscles")
    private List<Muscle> targetedMuscles = new ArrayList<>();

    public void addTargetedMuscle(Muscle muscle) {
        this.targetedMuscles.add(muscle);
    }

    public enum Difficulty {
        EASY, MODERATE, HARD
    }


}
