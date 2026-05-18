package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {
    private String message;
    private HttpStatus errorCode;
    private LocalDateTime timeStamp; 
    
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
    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public LocalDateTime getTimeStamp() {
        return this.timeStamp; 
    }
}
