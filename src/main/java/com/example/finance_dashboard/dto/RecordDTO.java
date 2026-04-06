package com.example.finance_dashboard.dto;


import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class RecordDTO {

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    private Double amount;

    @NotBlank(message = "Type is required (income/expense)")
    private String type;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String notes;
}