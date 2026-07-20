package com.keystone.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.keystone.dto.LoginRequest;
import com.keystone.dto.LoginResponse;
import com.keystone.entity.User;
import com.keystone.exception.ResourceNotFoundException;
import com.keystone.repository.UserRepository;
import com.keystone.service.AuthService;
import com.keystone.service.JwtService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder, 
                           JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ResourceNotFoundException("Invalid email or password");
        }
        
        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(token, "Login Successful");
    }
}