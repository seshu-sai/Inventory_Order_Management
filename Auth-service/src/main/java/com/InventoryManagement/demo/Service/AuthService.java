package com.InventoryManagement.demo.Service;

import com.InventoryManagement.demo.Model.User;
import com.InventoryManagement.demo.Repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationRepository authenticationRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public AuthService(AuthenticationRepository authenticationRepository
                        , PasswordEncoder passwordEncoder
                        , JwtService jwtService) {
        this.authenticationRepository = authenticationRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        authenticationRepository.save(user);
        return "User added successfully";
    }

    public String generateToken(String email) {
        return jwtService.generateToken(email);
    }

    public boolean validateToken(String token, User user) {
        return jwtService.validateToken(token, user);
    }

    public String extractUsername(String token) {
        return jwtService.extractUserName(token);
    }


}
