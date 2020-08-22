package com.philnguyen.fitness_share.repository;

import com.philnguyen.fitness_share.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select * from users where user_name = :username")
     Optional<User> findByUsername(@Param("username") String username);

}
