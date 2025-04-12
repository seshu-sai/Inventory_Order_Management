package com.InventoryManagement.StockMovement_service.Service;

import com.InventoryManagement.StockMovement_service.DTO.StockMovementDTO;

import java.util.List;

public interface StockMovementService {
    StockMovementDTO createMovement(StockMovementDTO dto);

    List<StockMovementDTO> getByProductId(Long productId);

    List<StockMovementDTO> getAllMovements();
}
