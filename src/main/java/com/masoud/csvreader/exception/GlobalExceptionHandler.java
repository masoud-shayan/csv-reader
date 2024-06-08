package com.masoud.csvreader.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ExceptionInfo> handleBusinessException(BusinessException ex) {
        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(ExceptionInfo.builder()
                        .timeStamp(Instant.now().toString())
                        .status(ex.getHttpStatus())
                        .message(ex.getMessage()).build());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionInfo> handleGeneralExceptions(Exception ex) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ExceptionInfo.builder()
                        .timeStamp(Instant.now().toString())
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .message(ex.getMessage()).build());
    }
}
