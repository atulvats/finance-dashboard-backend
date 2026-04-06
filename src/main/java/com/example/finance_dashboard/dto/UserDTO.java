package com.example.finance_dashboard.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Role is required")
    private String role;

    @NotBlank(message = "Status is required")
    private String status;
}