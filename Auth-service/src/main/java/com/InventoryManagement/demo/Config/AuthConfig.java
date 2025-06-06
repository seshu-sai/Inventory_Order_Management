package com.InventoryManagement.demo.Config;

import com.InventoryManagement.demo.Service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/auth/token").permitAll()
                        // Role-based access
                        .requestMatchers("/api/products/**").hasAnyAuthority("ADMIN", "USER")
                        .requestMatchers("/api/orders/**").hasAuthority("USER")
                        .requestMatchers("/api/suppliers/**").hasAuthority("ADMIN")
                        .requestMatchers("/api/categories/**").hasAuthority("ADMIN")
                        .requestMatchers("/api/categories").hasAuthority("ADMIN")
                        .requestMatchers("/api/orderItems/**").hasAnyAuthority("ADMIN", "USER")
                        .requestMatchers("/api/customers/**").hasAuthority("ADMIN")
                        .requestMatchers("/api/stockMovements/**").hasAuthority("ADMIN")

                        // Everything else requires auth
                        .anyRequest().authenticated()
                )
                .build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
