package com.example.HotelManagement.Controllar;

import com.example.HotelManagement.Entities.Users;
import com.example.HotelManagement.Services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    @Autowired
    private UserServices userServices;

    @PostMapping("register")
    public Optional<Users> registerUser(@Valid @RequestBody Users user){
        return userServices.registerUser(user);
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@Valid @RequestBody Users user){
        return userServices.loginUser(user);
    }

}
