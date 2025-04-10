package com.InventoryManagement.order_service.DTO;

import com.InventoryManagement.order_service.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

