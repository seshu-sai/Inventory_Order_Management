package com.InventoryManagement.order_service.Model;


import com.InventoryManagement.order_service.ForiegnDTO.OrderItemDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;
    private String status; // e.g., PENDING, COMPLETED
    private double totalAmount;

    private Long customerId;

    @Transient
    private List<OrderItemDTO> items;

    // Getters and Setters
}
