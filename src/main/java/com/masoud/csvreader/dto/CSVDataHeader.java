package com.masoud.csvreader.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CSVDataHeader {

    private String source;

    private String codeListCode;

    private String code;

    private String displayValue;

    private String longDescription;

    private String fromDate;

    private String toDate;

    private Integer sortingPriority;
}
