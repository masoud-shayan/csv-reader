package com.masoud.csvreader.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CSVData {

    @Id
    private String code;

    private String codeListCode;

    private String source;

    private String displayValue;

    private String longDescription;

    private String fromDate;

    private String toDate;

    private Integer sortingPriority;
}
