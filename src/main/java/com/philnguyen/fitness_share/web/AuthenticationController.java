package com.philnguyen.fitness_share.web;

import com.philnguyen.fitness_share.dto.AuthenticationRequestDto;
import com.philnguyen.fitness_share.model.AuthenticationResponse;
import com.philnguyen.fitness_share.security.UserRepositoryUserDetailsService;
import com.philnguyen.fitness_share.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private UserRepositoryUserDetailsService userRepositoryUserDetailsService;
    private JwtUtil jwtUtil;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UserRepositoryUserDetailsService userRepositoryUserDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userRepositoryUserDetailsService = userRepositoryUserDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestDto authenticationRequestDto) throws  Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userRepositoryUserDetailsService.loadUserByUsername(authenticationRequestDto.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }
}
