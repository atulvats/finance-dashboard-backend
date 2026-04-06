package com.example.finance_dashboard.service;

import com.example.finance_dashboard.dto.DashboardResponse;
import com.example.finance_dashboard.model.Record;
import com.example.finance_dashboard.repository.RecordRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final RecordRepository recordRepository;

    public DashboardService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    // ✅ MAIN METHOD (use this)
    public DashboardResponse getSummary() {

        double income = recordRepository.findByType("income")
                .stream()
                .mapToDouble(Record::getAmount)
                .sum();

        double expense = recordRepository.findByType("expense")
                .stream()
                .mapToDouble(Record::getAmount)
                .sum();

        double netBalance = income - expense;

        return new DashboardResponse(income, expense, netBalance);
    }
}