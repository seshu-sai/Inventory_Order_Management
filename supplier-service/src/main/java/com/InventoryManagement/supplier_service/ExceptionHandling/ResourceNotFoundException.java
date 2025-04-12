package com.InventoryManagement.supplier_service.ExceptionHandling;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
