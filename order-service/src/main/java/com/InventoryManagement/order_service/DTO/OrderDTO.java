package com.InventoryManagement.order_service.DTO;

import com.InventoryManagement.order_service.ForiegnDTO.OrderItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private LocalDateTime orderDate;
    private String status;
    private double totalAmount;
    private Long customerId;
    private List<OrderItemDTO> items;
}
