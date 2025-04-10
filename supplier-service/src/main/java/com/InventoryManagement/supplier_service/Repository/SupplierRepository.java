package com.InventoryManagement.supplier_service.Repository;

import com.InventoryManagement.supplier_service.Model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
