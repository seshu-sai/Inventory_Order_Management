package com.InventoryManagement.orderItem_service.Model;

import com.InventoryManagement.orderItem_service.ForiegnDTO.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service") // This name should match the service registered with Eureka
public interface ProductClient {

    @GetMapping("/api/products/{id}")
    ProductDTO getProductById(@PathVariable("id") Long id);

    @GetMapping("/api/products")
    List<ProductDTO> getAllProducts();
}
