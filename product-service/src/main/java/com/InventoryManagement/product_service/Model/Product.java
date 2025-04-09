package com.InventoryManagement.product_service.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String sku;
    private String description;
    private int quantity;
    private double price;
    private boolean active;


    private Long categoryId;
    private Long supplierId;



}
