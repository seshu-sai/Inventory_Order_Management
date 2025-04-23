package com.InventoryManagement.orderItem_service.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {
    private Long id;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
    private Long orderId;
    private Long productId;
    private String productName;

}
