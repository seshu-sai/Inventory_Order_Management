package com.InventoryManagement.supplier_service.Service;

import com.InventoryManagement.supplier_service.SupplierDTO.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO createSupplier(SupplierDTO supplierDTO);
    SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO);
    void deleteSupplier(Long id);
    SupplierDTO getSupplierById(Long id);
    List<SupplierDTO> getAllSuppliers();
}

