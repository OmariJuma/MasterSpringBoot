package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.UserRequestDto;
import com.example.demo.models.UserResponseDto;
import com.example.demo.service.UserService;

@RequestMapping("/api/v1/users")
@RestController
public class UserController{
    private final UserService service;
    
    public UserController(UserService service){
        this.service = service;
            }
            
    @PostMapping
    public ResponseEntity<UserResponseDto> getUsers(@RequestBody UserRequestDto user){
        UserResponseDto createdUser = service.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);    }
        
       // @PatchMapping
       // public ResponseEntity<UserResponseDto> updateUser(@RequestBody User)
    
    
}