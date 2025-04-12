package com.InventoryManagement.StockMovement_service.Service;

package com.InventoryManagement.stockMovement_service.Service;

import com.InventoryManagement.StockMovement_service.DTO.StockMovementDTO;
import com.InventoryManagement.stockMovement_service.DTO.StockMovementDTO;
import com.InventoryManagement.stockMovement_service.Model.StockMovement;
import com.InventoryManagement.stockMovement_service.Repository.StockMovementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StockMovementServiceImpl implements StockMovementService {
    
    @Override
    public StockMovementDTO createMovement(StockMovementDTO dto) {
        StockMovement movement = modelMapper.map(dto, StockMovement.class);
        movement.setTimestamp(LocalDateTime.now());
        return modelMapper.map(repository.save(movement), StockMovementDTO.class);
    }

    @Override
    public List<StockMovementDTO> getByProductId(Long productId) {
        return List.of();
    }

    @Override
    public List<StockMovementDTO> getAllMovements() {
        return List.of();
    }
}
