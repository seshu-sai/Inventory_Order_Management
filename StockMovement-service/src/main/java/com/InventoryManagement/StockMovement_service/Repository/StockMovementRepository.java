package com.InventoryManagement.StockMovement_service.Repository;


import com.InventoryManagement.StockMovement_service.Model.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
    List<StockMovement> findByProductId(Long productId);
}
