package com.philnguyen.fitness_share.dto;

import com.philnguyen.fitness_share.model.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class UserDto {
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String email;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(first_name, last_name, username, passwordEncoder.encode(password), email);
    }
}
