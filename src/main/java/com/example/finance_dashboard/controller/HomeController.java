package com.example.finance_dashboard.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Finance Dashboard API is running 🚀";
    }
}
