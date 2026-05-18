package com.example.demo.exception;

import java.time.ZonedDateTime;
import java.time.ZoneId;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler{
    @ExceptionHandler(value ={ApiExceptionRequest.class})
    public ResponseEntity<ApiException> handleException(ApiExceptionRequest exception){
        ApiException newException = new ApiException();
        HttpStatus code = HttpStatus.BAD_REQUEST;
        newException.setMessage(exception.getMessage());
        newException.setErrorCode(code);
        newException.setTimeStamp(ZonedDateTime.now(ZoneId.of("Africa/Nairobi")));
        return new ResponseEntity<>(newException, code);
        }
        
}