package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ApiExceptionRequest;
import com.example.demo.models.User;
import com.example.demo.repository.*;

@Service
public class UserService{
    
    private  final UserRepository userRepository;
    
    public UserService  (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
      public User createUser(Integer id, String name){
        
          if(userRepository.findById(id).isPresent()){
              throw new ApiExceptionRequest("User exists");
          }
          User newUser = new User(id, name);
       return userRepository.save(newUser);
    }
    
}