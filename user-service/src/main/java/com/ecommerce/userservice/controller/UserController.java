package com.ecommerce.userservice.controller;

import com.ecommerce.userservice.dto.AuthenticationRequest;
import com.ecommerce.userservice.dto.AuthenticationResponse;
import com.ecommerce.userservice.dto.RegisterRequest;
import com.ecommerce.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        String result = userService.register(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = userService.authenticate(request);
        return ResponseEntity.ok(response);
    }

}
