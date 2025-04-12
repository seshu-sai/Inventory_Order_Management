package com.InventoryManagement.product_service.Model;
import com.InventoryManagement.product_service.Configuration.FeignConfig;
import com.InventoryManagement.product_service.ForiegnDTO.SupplierDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "supplier-service", configuration = FeignConfig.class)
public interface SupplierClient {
    @GetMapping("/api/suppliers/{id}")
    SupplierDTO getSupplierById(@PathVariable Long id);
}
