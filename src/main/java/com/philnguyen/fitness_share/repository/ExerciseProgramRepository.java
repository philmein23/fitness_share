package com.philnguyen.fitness_share.repository;

import com.philnguyen.fitness_share.model.ExerciseProgram;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseProgramRepository extends CrudRepository<ExerciseProgram, Long> {

    @Query("select count(*) from exercise_programs")
    public Integer countPrograms();


    // query for exercise program based on the condition that it contains the requested exercise
}
