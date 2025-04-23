package com.InventoryManagement.demo.Controller;


import com.InventoryManagement.demo.Model.User;
import com.InventoryManagement.demo.Repository.AuthenticationRepository;
import com.InventoryManagement.demo.Service.AuthService;
import com.InventoryManagement.demo.Service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    private final AuthenticationRepository authenticationRepository;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthService authService,
                          AuthenticationRepository authenticationRepository,
                          AuthenticationManager authenticationManager,
                          PasswordEncoder passwordEncoder) {
        this.authService = authService;
        this.authenticationRepository = authenticationRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String addUser(@RequestBody User user) {
          return authService.saveUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody User user) {
        // Authenticate user with email and password
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
        );

        if (authenticate.isAuthenticated()) {
            // Fetch the user from DB to get correct authority
            User dbUser = authenticationRepository.findByEmail(user.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Generate token with correct authority
            return authService.generateToken(dbUser.getEmail(), dbUser.getAuthority());
        } else {
            throw new RuntimeException("Authentication failed");
        }
    }


    @GetMapping("/validate")
    public boolean validateToken(@RequestParam String token) {
        String username = authService.extractUsername(token);
        return authenticationRepository.findByEmail(username)
                .map(user -> authService.validateToken(token, user))
                .orElse(false);
    }

}
