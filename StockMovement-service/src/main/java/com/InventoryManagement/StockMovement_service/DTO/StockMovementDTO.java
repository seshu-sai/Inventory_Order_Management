package com.InventoryManagement.StockMovement_service.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockMovementDTO {
    private Long id;
    private int quantityChanged;
    private String reason;
    private LocalDateTime timestamp;
    private Long productId;


}

