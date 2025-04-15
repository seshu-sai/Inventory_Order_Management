package com.InventoryManagement.demo.Service;

import com.InventoryManagement.demo.Config.CustomUserDetails;
import com.InventoryManagement.demo.Model.User;
import com.InventoryManagement.demo.Repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    public CustomUserDetailsService() {
    };


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = authenticationRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // 👇 Do not use "ROLE_" prefix since you're using hasAuthority()
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getAuthority()))  // e.g., "ADMIN"
        );
    }

}
