package com.philnguyen.fitness_share.repository;

import com.philnguyen.fitness_share.model.Exercise;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

    @Query("SELECT * from EXERCISES WHERE exercise_name = :exerciseName")
    public List<Exercise> findExerciseByName(@Param("exerciseName") String exerciseName);

}

