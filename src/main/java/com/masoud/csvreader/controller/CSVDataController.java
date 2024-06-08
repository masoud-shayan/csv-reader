package com.masoud.csvreader.controller;

import com.masoud.csvreader.entitiy.CSVData;
import com.masoud.csvreader.service.CSVDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController("/api/v1/csv")
@RequiredArgsConstructor
public class CSVDataController {

    private final CSVDataService csvDataService;

    @GetMapping("")
    List<CSVData> fetchAll() {
        return csvDataService.fetchAll();
    }

    @GetMapping("/{code}")
    CSVData fetchByCode(@PathVariable String code) {
        return csvDataService.fetchByCode(code);
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public List<CSVData> uploadFile(@RequestPart("file") MultipartFile file) {
        return csvDataService.upload(file);
    }

    @DeleteMapping("")
    void deleteAll() {
        csvDataService.deleteAll();
    }

}
