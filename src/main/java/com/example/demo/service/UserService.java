package com.example.demo.service;

import java.time.ZonedDateTime;
import java.util.List;
import java.time.ZoneId;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ApiExceptionRequest;
import com.example.demo.models.User;
import com.example.demo.models.UserPrincipal;
import com.example.demo.models.UserRequestDto;
import com.example.demo.models.UserResponseDto;
import com.example.demo.repository.*;

@Service
public class UserService implements UserDetailsService {
    
    private  final UserRepository userRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public UserService  (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
        @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        
        if(user == null){
System.out.println("User Not Found");
throw new UsernameNotFoundException("user not found");
}
return new UserPrincipal(user);
        
        }
      public UserResponseDto createUser(UserRequestDto user){
        
          if(userRepository.findById(user.getId()).isPresent()){
              throw new ApiExceptionRequest("User exists");
          }
          ZonedDateTime time = ZonedDateTime.now(ZoneId.of("Africa/Nairobi"));
          String hashedPass = encoder.encode(user.getPassword());
          User newUser = new User( );
          newUser.setId(user.getId());
          newUser.setName(user.getName());
          newUser.setEmail(user.getEmail());
          newUser.setPassword(hashedPass);
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