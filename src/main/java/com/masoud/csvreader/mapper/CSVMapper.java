package com.masoud.csvreader.mapper;

import com.masoud.csvreader.dto.CSVDataHeader;
import com.masoud.csvreader.entitiy.CSVData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CSVMapper {

    CSVData toEntity(CSVDataHeader dataHeader);
}
