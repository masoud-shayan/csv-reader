package com.masoud.csvreader.service;

import com.masoud.csvreader.entitiy.CSVData;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CSVDataService {

    List<CSVData> fetchAll();

    CSVData fetchByCode(String code);

    List<CSVData> upload(MultipartFile file);

    void deleteAll();
}
