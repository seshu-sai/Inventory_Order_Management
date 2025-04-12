package com.InventoryManagement.product_service.ExceptionHandling;


import feign.Response;
import feign.codec.ErrorDecoder;
import feign.FeignException;
import org.springframework.http.HttpStatus;

public class CustomFeignErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == HttpStatus.NOT_FOUND.value()) {
            return new ResourceNotFoundException("Supplier not found");
        }
        return defaultDecoder.decode(methodKey, response);
    }
}

