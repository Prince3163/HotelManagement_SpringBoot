package com.example.HotelManagement.Services.Implements;

import com.example.HotelManagement.Entities.UserPrinciple;
import com.example.HotelManagement.Entities.Users;
import com.example.HotelManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);

        if(user == null)
        {
            throw new RuntimeException("User not Found.");
        }

        return new UserPrinciple(user);
    }
}
