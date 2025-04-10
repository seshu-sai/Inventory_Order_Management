package com.InventoryManagement.supplier_service.Service;

import com.InventoryManagement.supplier_service.ExceptionHandling.ResourceNotFoundException;
import com.InventoryManagement.supplier_service.Repository.SupplierRepository;
import com.InventoryManagement.supplier_service.Model.Supplier;
import com.InventoryManagement.supplier_service.SupplierDTO.SupplierDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = modelMapper.map(supplierDTO, Supplier.class);
        Supplier saved = supplierRepository.save(supplier);
        return modelMapper.map(saved, SupplierDTO.class);
    }

    @Override
    public SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));

        supplier.setName(supplierDTO.getName());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setContactNumber(supplierDTO.getContactNumber());
        supplier.setAddress(supplierDTO.getAddress());

        Supplier updated = supplierRepository.save(supplier);
        return modelMapper.map(updated, SupplierDTO.class);
    }

    @Override
    public void deleteSupplier(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));
        supplierRepository.delete(supplier);
    }

    @Override
    public SupplierDTO getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));
        return modelMapper.map(supplier, SupplierDTO.class);
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream()
                .map(s -> modelMapper.map(s, SupplierDTO.class))
                .collect(Collectors.toList());
    }
}

