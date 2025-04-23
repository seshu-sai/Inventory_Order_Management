package com.InventoryManagement.order_service.ForiegnDTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class OrderItemDTO {

    private Long id;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
    private Long orderId;
    private Long productId;
    private String productName;
}
