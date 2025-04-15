package com.InventoryManagement.demo.Controller;


import com.InventoryManagement.demo.Model.User;
import com.InventoryManagement.demo.Repository.AuthenticationRepository;
import com.InventoryManagement.demo.Service.AuthService;
import com.InventoryManagement.demo.Service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    private final AuthenticationRepository authenticationRepository;

    private final AuthenticationManager authenticationManager;

    public AuthController(AuthService authService,
                          AuthenticationRepository authenticationRepository,
                          AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.authenticationRepository = authenticationRepository;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public String addUser(@RequestBody User user) {
        System.out.println(user);
        System.out.println(authService.generateToken(user.getEmail(), user.getAuthority()));
          authService.saveUser(user);
          return authService.generateToken(user.getEmail(), user.getAuthority());
    }

    @PostMapping("/token")
    public String getToken(@RequestBody User user) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
        );
        if (authenticate.isAuthenticated()) {
            return authService.generateToken(user.getEmail(), user.getAuthority());
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
