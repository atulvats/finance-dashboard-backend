package com.example.finance_dashboard.controller;

import com.example.finance_dashboard.dto.RecordDTO;
import com.example.finance_dashboard.model.Record;
import com.example.finance_dashboard.service.RecordService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    // CREATE RECORD
    @Operation(summary = "Create financial record")
    @PostMapping
    public Record create(@Valid @RequestBody RecordDTO dto) {
        return recordService.createRecord(dto);
    }

    // GET ALL RECORDS
    @Operation(summary = "Get all records")
    @GetMapping
    public List<Record> getAll() {
        return recordService.getAllRecords();
    }

    // GET RECORD BY ID
    @Operation(summary = "Get record by ID")
    @GetMapping("/{id}")
    public Record getById(@PathVariable Long id) {
        return recordService.getRecordById(id);
    }

    // UPDATE RECORD
    @Operation(summary = "Update record")
    @PutMapping("/{id}")
    public Record update(@PathVariable Long id, @Valid @RequestBody RecordDTO dto) {
        return recordService.updateRecord(id, dto);
    }

    // DELETE RECORD
    @Operation(summary = "Delete record")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        recordService.deleteRecord(id);
    }
}