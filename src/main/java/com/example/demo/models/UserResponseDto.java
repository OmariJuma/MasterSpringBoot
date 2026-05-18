package com.example.demo.models;

import java.time.ZonedDateTime;

public class UserResponseDto{
   private  Integer id;
  private   String name;
 private   String email;
    private ZonedDateTime createdAt;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Name Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Email Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public ZonedDateTime getCreatedAt(){
        return createdAt;
        }
        
    public void setCreatedAt(ZonedDateTime createdAt){
        this.createdAt = createdAt;
        }
    }