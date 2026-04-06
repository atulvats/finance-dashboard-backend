package com.example.finance_dashboard.repository;

import com.example.finance_dashboard.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByType(String type);
}