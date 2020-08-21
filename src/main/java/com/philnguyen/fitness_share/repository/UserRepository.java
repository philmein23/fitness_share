package com.philnguyen.fitness_share.repository;

import com.philnguyen.fitness_share.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select * from users where username = :username")
    public User findByUsername(@Param("username") String username);

}
