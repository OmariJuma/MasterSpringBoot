package com.example.demo.service;

import java.time.ZonedDateTime;
import java.util.List;
import java.time.ZoneId;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ApiExceptionRequest;
import com.example.demo.models.User;
import com.example.demo.models.UserRequestDto;
import com.example.demo.models.UserResponseDto;
import com.example.demo.repository.*;

@Service
public class UserService{
    
    private  final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder ;  
    public UserService  (UserRepository userRepository
    //, PasswordEncoder passwordEncoder
    ){
        this.userRepository = userRepository;
       // this.passwordEncoder =passwordEncoder;
    }
    
      public UserResponseDto createUser(UserRequestDto user){
        
          if(userRepository.findById(user.getId()).isPresent()){
              throw new ApiExceptionRequest("User exists");
          }
          ZonedDateTime time = ZonedDateTime.now(ZoneId.of("Africa/Nairobi"));
          //String hashedPass = passwordEncoder.encode(user.getPassword());
          User newUser = new User( );
          newUser.setId(user.getId());
          newUser.setName(user.getName());
          newUser.setEmail(user.getEmail());
          newUser.setPassword(user.getPassword());
          newUser.setCreatedAt(time);
          newUser.setUpdatedAt(time);
       User createdUser = userRepository.save(newUser);
       return responseDto(createdUser);
    }
    
    public List<UserResponseDto> getAllUsers(){
        List<User>allUsers = userRepository.findAll();
        if(allUsers.isEmpty()){
             throw new ApiExceptionRequest("No users present");
            }
            return allUsers.stream().map(UserService::responseDto).toList();   }
    
    
    public static  UserResponseDto responseDto(User user){
          UserResponseDto newUser = new 
UserResponseDto();
          newUser.setId(user.getId());
          newUser.setName(user.getName());
          newUser.setEmail(user.getEmail());
          newUser.setCreatedAt(user.getCreatedAt());
           return newUser;
          }
    
    //public User updateUser(Integer id, String name){
        
      //  }
      
     
    
}