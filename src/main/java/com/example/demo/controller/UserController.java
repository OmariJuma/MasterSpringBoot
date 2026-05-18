package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.service.UserService;

@RequestMapping("/api/v1/users")
@RestController
public class UserController{
    private final UserService service;
    
    public UserController(UserService service){
        this.service = service;
            }
            
    @PostMapping
    public ResponseEntity<Object> getUsers(@RequestBody User user){
        System.out.println(user.id +" " + user.name);
        User createdUser = service.createUser(user.id, user.name);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    
    
}