package com.example.finance_dashboard.repository;

import com.example.finance_dashboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}