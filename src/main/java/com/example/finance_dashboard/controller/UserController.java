package com.example.finance_dashboard.controller;

import com.example.finance_dashboard.dto.UserDTO;
import com.example.finance_dashboard.model.User;
import com.example.finance_dashboard.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create User
    @Operation(summary = "Create a new user")
    @PostMapping
    public User createUser(@Valid @RequestBody UserDTO dto) {
        return userService.createUser(dto);
}

    // Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get User by ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Update User

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO dto) {    
        return userService.updateUser(id, dto);
    }

    // Delete User
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}