package com.ecommerce.userservice.service;

import com.ecommerce.userservice.dto.AuthenticationRequest;
import com.ecommerce.userservice.dto.AuthenticationResponse;
import com.ecommerce.userservice.dto.RegisterRequest;
import com.ecommerce.userservice.model.Role;
import com.ecommerce.userservice.model.User;
import com.ecommerce.userservice.repository.UserRepository;
import com.ecommerce.userservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return "User already exists with this email";
        }
        Role roleToSet = Role.CUSTOMER; // default role

        // If role is explicitly provided (like ADMIN or SELLER), set it
        if (request.getRole() != null) {
            roleToSet = request.getRole();
        }
        User user = User.builder()
                .email(request.getEmail())
                .role(roleToSet)
                .password(passwordEncoder.encode(request.getPassword())).build();
        userRepository.save(user);
        return "User registered successfully!";
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        String jwtToken = jwtService.generateToken(user.getEmail());
        return AuthenticationResponse.builder().jwt(jwtToken).build();
    }
}
