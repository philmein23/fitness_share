package com.philnguyen.fitness_share.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.philnguyen.fitness_share.model.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class UserDto {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("user_name")
    private String userName;
    private String password;
    private String email;
}
