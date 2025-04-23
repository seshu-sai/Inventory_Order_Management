package com.InventoryManagement.order_service.Model;

import com.InventoryManagement.order_service.ForiegnDTO.OrderItemDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductClient {

    @GetMapping("/api/products/{id}")
    List<OrderItemDTO> getProductNameUsingId(@PathVariable("id") Long productId);
}
