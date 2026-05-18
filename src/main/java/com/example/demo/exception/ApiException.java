package com.example.demo.exception;

import java.time.ZonedDateTime;
import java.time.ZoneId;

import org.springframework.http.HttpStatus;

public class ApiException {
    private String message;
    private HttpStatus errorCode;
    private ZonedDateTime timeStamp; 
    
    public ApiException() {} 
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public HttpStatus getErrorCode() {
        return this.errorCode;
    }
    public void setTimeStamp(ZonedDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public ZonedDateTime getTimeStamp() {
        return this.timeStamp; 
    }
}
