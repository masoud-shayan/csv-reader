package com.masoud.csvreader.service.impl;

import com.masoud.csvreader.dto.CSVDataHeader;
import com.masoud.csvreader.entitiy.CSVData;
import com.masoud.csvreader.exception.BusinessException;
import com.masoud.csvreader.mapper.CSVMapper;
import com.masoud.csvreader.repository.CSVDataRepository;
import com.masoud.csvreader.service.CSVDataService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CSVDataServiceImpl implements CSVDataService {

    private final CSVDataRepository csvDataRepository;
    private final CSVMapper csvMapper;


    @Override
    public List<CSVData> fetchAll() {
        return csvDataRepository.findAll();
    }

    @Override
    public CSVData fetchByCode(String code) {
        return csvDataRepository.findById(code)
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "There is no data for the provided code"));
    }

    @Override
    public List<CSVData> upload(MultipartFile file) {

        Set<CSVData> csvDataSet = parseCsvFile(file);

        if (isCodeAlreadyExists(csvDataSet))
            throw new BusinessException(HttpStatus.BAD_REQUEST, "There are/is duplicate row(s)");

        return csvDataRepository.saveAll(csvDataSet);
    }

    @Override
    public void deleteAll() {
        csvDataRepository.deleteAll();
    }


    private Set<CSVData> parseCsvFile(MultipartFile file) {

        Set<CSVData> csvDataSet = null;

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<CSVDataHeader> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(CSVDataHeader.class);

            CsvToBean<CSVDataHeader> csvToBean = new CsvToBeanBuilder<CSVDataHeader>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreEmptyLine(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            csvDataSet = csvToBean.parse()
                    .stream()
                    .map(csvMapper::toEntity)
                    .collect(Collectors.toSet());


        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return csvDataSet;
    }

    private boolean isCodeAlreadyExists(Set<CSVData> csvDataSet) {
        return csvDataRepository.existsAllByCodeIn(csvDataSet.stream().map(CSVData::getCode).collect(Collectors.toSet()));
    }
}
