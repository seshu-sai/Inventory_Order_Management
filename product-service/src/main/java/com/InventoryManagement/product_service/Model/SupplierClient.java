package com.InventoryManagement.product_service.Model;
import com.InventoryManagement.product_service.ForiegnDTO.SupplierDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "supplier-client")
public interface SupplierClient {
    @GetMapping("/api/supplier/{id}")
    SupplierDTO getSupplierById(@PathVariable Long id);
}
