package com.example.demo.exception;

public class ApiExceptionRequest extends RuntimeException{
    public ApiExceptionRequest(String message){
        super(message);
    }
}