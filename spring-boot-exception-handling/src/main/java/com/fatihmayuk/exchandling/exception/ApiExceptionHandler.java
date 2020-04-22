package com.fatihmayuk.exchandling.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public String entityNotFound(){

        return "Record not found";
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public String IAException(){

        return "Wrong parameter";
    }
}
