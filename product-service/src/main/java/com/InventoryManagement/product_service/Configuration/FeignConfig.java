package com.InventoryManagement.product_service.Configuration;

import com.InventoryManagement.product_service.ExceptionHandling.CustomFeignErrorDecoder;
import org.springframework.context.annotation.Bean;


public class FeignConfig {
    @Bean
    public CustomFeignErrorDecoder customFeignErrorDecoder() {
        return new CustomFeignErrorDecoder();
    }
}
