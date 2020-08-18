package com.philnguyen.fitness_share;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.philnguyen.fitness_share.model.Exercise;
import com.philnguyen.fitness_share.model.ExerciseProgram;
import com.philnguyen.fitness_share.model.Muscle;
import com.philnguyen.fitness_share.repository.ExerciseProgramRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FitnessShareApplicationTests {

    @Autowired
    private ExerciseProgramRepository exerciseProgramRepository;

    @Test
    void contextLoads() {
        List<Exercise> exercises = new ArrayList<>();
        List<Muscle> muscles = new ArrayList<>();
        List<Muscle> muscles2 = new ArrayList<>();
        muscles.add(new Muscle(null, "triceps"));
        muscles2.add(new Muscle(null, "latissimus dorsi"));
        muscles2.add(new Muscle(null, "biceps"));
        Exercise e1 = new Exercise(null, "dips", "test", 7, muscles);
        Exercise e2 = new Exercise(null, "wide grip pull ups", "test", 7, muscles2);


        exercises.add(e1);
        exercises.add(e2);

        ExerciseProgram program = new ExerciseProgram(null, "some program", exercises);
        ExerciseProgram exerciseProgram = exerciseProgramRepository.save(program);

        assertEquals(2, exerciseProgram.getExercises().stream().count());

        System.out.println(exerciseProgramRepository.findAll());

    }

}
