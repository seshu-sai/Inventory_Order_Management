package com.InventoryManagement.demo.Repository;

import com.InventoryManagement.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
