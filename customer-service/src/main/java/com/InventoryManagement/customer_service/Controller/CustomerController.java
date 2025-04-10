package com.InventoryManagement.customer_service.Controller;


import com.InventoryManagement.customer_service.DTO.CustomerDTO;
import com.InventoryManagement.customer_service.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public CustomerDTO create(@RequestBody CustomerDTO dto) {
        return service.createCustomer(dto);
    }

    @GetMapping("/{id}")
    public CustomerDTO getById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @GetMapping
    public List<CustomerDTO> getAll() {
        return service.getAllCustomers();
    }

    @PutMapping("/{id}")
    public CustomerDTO update(@PathVariable Long id, @RequestBody CustomerDTO dto) {
        return service.updateCustomer(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCustomer(id);
    }
}

