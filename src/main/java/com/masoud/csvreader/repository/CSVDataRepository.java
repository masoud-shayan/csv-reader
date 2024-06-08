package com.masoud.csvreader.repository;

import com.masoud.csvreader.entitiy.CSVData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CSVDataRepository extends JpaRepository<CSVData, String> {

    boolean existsAllByCodeIn(Set<String> codes);
}
