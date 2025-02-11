package com.example.HotelManagement.Services;

import com.example.HotelManagement.Entities.Users;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserServices {
    public Optional<Users> registerUser(Users user);

    public ResponseEntity<String> loginUser(Users user);

    public ResponseEntity<String> logout();

    public Optional<Users> updateUser(Users user);

    public ResponseEntity<String> deleteUser(Users user);

    public Optional<Users> updateRoles(List<String> roles);
}
