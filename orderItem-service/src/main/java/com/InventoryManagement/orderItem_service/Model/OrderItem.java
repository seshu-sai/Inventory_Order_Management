package com.InventoryManagement.orderItem_service.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_items")
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
    private Long orderId;
    private Long productId;
    private String productName;
}

