package com.example.finance_dashboard.service;

import com.example.finance_dashboard.dto.RecordDTO;
import com.example.finance_dashboard.exception.CustomException;
import com.example.finance_dashboard.model.Record;
import com.example.finance_dashboard.repository.RecordRepository;
import com.example.finance_dashboard.util.Constants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    private final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    // CREATE RECORD
    public Record createRecord(RecordDTO dto) {

        Record record = new Record();

        record.setAmount(dto.getAmount());
        record.setType(dto.getType().toLowerCase());
        record.setCategory(dto.getCategory());
        record.setDate(dto.getDate());
        record.setNotes(dto.getNotes());

        return recordRepository.save(record);
    }

    // GET ALL RECORDS
    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    // GET RECORD BY ID
    public Record getRecordById(Long id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new CustomException(Constants.RECORD_NOT_FOUND));
    }

    // UPDATE RECORD
    public Record updateRecord(Long id, RecordDTO dto) {

        Record record = getRecordById(id);

        record.setAmount(dto.getAmount());
        record.setType(dto.getType().toLowerCase());
        record.setCategory(dto.getCategory());
        record.setDate(dto.getDate());
        record.setNotes(dto.getNotes());

        return recordRepository.save(record);
    }

    // DELETE RECORD
    public void deleteRecord(Long id) {

        if (!recordRepository.existsById(id)) {
            throw new CustomException(Constants.RECORD_NOT_FOUND);
        }

        recordRepository.deleteById(id);
    }
}