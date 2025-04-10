package com.InventoryManagement.product_service.Model;

import com.InventoryManagement.product_service.ForiegnDTO.CategoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "category-service")
public interface CategoryClient {

    @GetMapping("/api/categories/{id}")
    CategoryDTO getCategoryById(@PathVariable Long id);

}
