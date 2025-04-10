package com.InventoryManagement.customer_service.Repository;

import com.InventoryManagement.customer_service.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
