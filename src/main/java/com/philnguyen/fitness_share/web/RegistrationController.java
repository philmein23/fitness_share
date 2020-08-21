package com.philnguyen.fitness_share.web;

import com.philnguyen.fitness_share.dto.UserDto;
import com.philnguyen.fitness_share.model.User;
import com.philnguyen.fitness_share.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public User processRegistration(@RequestBody UserDto newUserRegistration) {
       return userRepository.save(newUserRegistration.toUser(passwordEncoder));
    }
}
