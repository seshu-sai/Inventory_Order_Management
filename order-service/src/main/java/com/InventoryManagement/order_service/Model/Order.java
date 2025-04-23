package com.InventoryManagement.order_service.Model;


import com.InventoryManagement.order_service.ForiegnDTO.OrderItemDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;
    private String status; // e.g., PENDING, COMPLETED
    private double totalAmount;

    private Long customerId;

    private String productName;

    @Transient
    private List<OrderItemDTO> items;

    // Getters and Setters
}
