package com.example.HotelManagement.Services.Implements;

import com.example.HotelManagement.Entities.Users;
import com.example.HotelManagement.Exceptions.InvalidCredentialsException;
import com.example.HotelManagement.Exceptions.ObjectAlredyExistsException;
import com.example.HotelManagement.Repository.UserRepository;
import com.example.HotelManagement.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTServicesImpl jwtServices;

    @Autowired
    private AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Override
    public Optional<Users> registerUser(Users user) {

        if(userRepository.existsByUsername(user.getUsername()))
            throw new ObjectAlredyExistsException("Username alredy exist.");

        checkPasswordValidation(user.getPassword());

        String encPassword = encoder.encode(user.getPassword());
        user.setPassword( encPassword );
        userRepository.save(user);

        return userRepository.findById(user.getId());
    }

    @Override
    public ResponseEntity<String> loginUser(Users user) {

        if(! userRepository.existsByUsername(user.getUsername()))
            throw new ObjectAlredyExistsException("Username not exist, You have to register first.");

        checkPasswordValidation(user.getPassword());

        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken( user.getUsername(),user.getPassword()));

        if (authentication.isAuthenticated()){
            return new ResponseEntity<>("Success,\nJWT: "+jwtServices.generateToken( user.getUsername() ), HttpStatus.OK );
        }
        return new ResponseEntity<>("Login Failed",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> logout() {
        return null;
    }

    @Override
    public Optional<Users> updateUser(Users user) {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<String> deleteUser(Users user) {
        return null;
    }

    @Override
    public Optional<Users> updateRoles(List<String> roles) {
        return Optional.empty();
    }

    public void checkPasswordValidation(String password){

        int lengthOfPassword = password.trim().length();
        if ( lengthOfPassword < 6 || lengthOfPassword > 15 )
            throw new InvalidCredentialsException("Password must be between 6 and 15 characters.");

    }
}
