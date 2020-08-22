package com.philnguyen.fitness_share.security;

import com.philnguyen.fitness_share.model.MyUserDetails;
import com.philnguyen.fitness_share.model.User;
import com.philnguyen.fitness_share.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserRepositoryUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(user -> {
                    MyUserDetails userDetails = new MyUserDetails();
                    userDetails.setUsername(user.getUserName());
                    userDetails.setPassword(user.getPassword());

                    return userDetails;
                })
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

    }
}
