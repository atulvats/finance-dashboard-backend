package com.example.finance_dashboard.service;

import com.example.finance_dashboard.dto.UserDTO;
import com.example.finance_dashboard.exception.CustomException;
import com.example.finance_dashboard.model.Role;
import com.example.finance_dashboard.model.User;
import com.example.finance_dashboard.repository.UserRepository;
import com.example.finance_dashboard.util.Constants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE USER
    public User createUser(UserDTO dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        // Role Validation
        try {
            user.setRole(Role.valueOf(dto.getRole().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new CustomException(Constants.INVALID_ROLE);
        }

        user.setStatus(dto.getStatus());

        return userRepository.save(user);
    }

    // GET ALL USERS
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET USER BY ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new CustomException(Constants.USER_NOT_FOUND));
    }

    // UPDATE USER
    public User updateUser(Long id, UserDTO dto) {

        User user = getUserById(id);

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        // Role Validation
        try {
            user.setRole(Role.valueOf(dto.getRole().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new CustomException(Constants.INVALID_ROLE);
        }

        user.setStatus(dto.getStatus());

        return userRepository.save(user);
    }

    // DELETE USER
    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new CustomException(Constants.USER_NOT_FOUND);
        }

        userRepository.deleteById(id);
    }
}