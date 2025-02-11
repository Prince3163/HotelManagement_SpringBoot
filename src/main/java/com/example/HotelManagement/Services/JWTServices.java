package com.example.HotelManagement.Services;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.util.function.Function;

public interface JWTServices {

    public String generateToken(String username);
    public String extractUsername(String token);
    public boolean validateToken(String token, UserDetails userDetails);

}
