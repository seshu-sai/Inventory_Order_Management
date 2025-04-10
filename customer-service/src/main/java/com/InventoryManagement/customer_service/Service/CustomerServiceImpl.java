package com.InventoryManagement.customer_service.Service;

import com.InventoryManagement.customer_service.DTO.CustomerDTO;
import com.InventoryManagement.customer_service.Model.Customer;
import com.InventoryManagement.customer_service.Repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CustomerDTO createCustomer(CustomerDTO dto) {
        Customer customer = mapper.map(dto, Customer.class);
        return mapper.map(repository.save(customer), CustomerDTO.class);
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        return mapper.map(customer, CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return repository.findAll().stream()
                .map(customer -> mapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO dto) {
        Customer customer = repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        return mapper.map(repository.save(customer), CustomerDTO.class);
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}

