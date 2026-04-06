package com.example.finance_dashboard.controller;

import com.example.finance_dashboard.dto.AuthRequestDTO;
import com.example.finance_dashboard.dto.AuthResponseDTO;
import com.example.finance_dashboard.exception.CustomException;
import com.example.finance_dashboard.security.JwtUtil;
import com.example.finance_dashboard.util.Constants;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@Valid @RequestBody AuthRequestDTO request) {

        String username = request.getUsername();
        String password = request.getPassword();

        String role;

        if ("admin".equals(username) && "admin123".equals(password)) {
            role = "ADMIN";
        } else if ("analyst".equals(username) && "analyst123".equals(password)) {
            role = "ANALYST";
        } else if ("viewer".equals(username) && "viewer123".equals(password)) {
            role = "VIEWER";
        } else {
            throw new CustomException(Constants.INVALID_CREDENTIALS);
        }

        String token = jwtUtil.generateToken(username, role);

        return new AuthResponseDTO(token);
    }
}