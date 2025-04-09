package com.InventoryManagement.order_service.Model;


import com.InventoryManagement.order_service.ForiegnDTO.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerClient {
    @GetMapping("/api/customers/{id}")
    CustomerDTO getCustomerId(@PathVariable Long id);
}

