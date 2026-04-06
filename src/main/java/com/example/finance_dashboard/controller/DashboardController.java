package com.example.finance_dashboard.controller;

import com.example.finance_dashboard.dto.DashboardResponse;
import com.example.finance_dashboard.service.DashboardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/summary")
    public DashboardResponse getSummary() {
        return dashboardService.getSummary();
    }
}