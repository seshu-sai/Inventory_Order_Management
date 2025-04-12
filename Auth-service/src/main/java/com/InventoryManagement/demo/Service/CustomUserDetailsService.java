package com.InventoryManagement.demo.Service;

import com.InventoryManagement.demo.Config.CustomUserDetails;
import com.InventoryManagement.demo.Model.User;
import com.InventoryManagement.demo.Repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    public CustomUserDetailsService() {
    };


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user =  authenticationRepository.findByEmail(email);
        return user.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
