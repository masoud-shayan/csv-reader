package com.masoud.csvreader.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
public class ExceptionInfo {

    private String timeStamp;
    private HttpStatus status;
    private String message;
}
