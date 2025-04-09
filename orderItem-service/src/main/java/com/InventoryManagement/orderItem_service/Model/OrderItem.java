package com.InventoryManagement.orderItem_service.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private double unitPrice;
    private double totalPrice;

    @Column(name="order_id")
    private Long order;

    private Long product;
}

