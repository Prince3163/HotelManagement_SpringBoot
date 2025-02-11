package com.example.HotelManagement.Services;

import org.springframework.security.core.userdetails.UserDetails;

public interface MyuserDetailsService {
    public UserDetails loadUserByUsername(String username);
}
