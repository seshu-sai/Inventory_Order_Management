package com.InventoryManagement.supplier_service.ExceptionHandling;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(String product, String id, Long id1) {
        super("Supplier with id " + id + " not found");
    }
}
