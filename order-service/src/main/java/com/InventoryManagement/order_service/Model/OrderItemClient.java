package com.InventoryManagement.order_service.Model;

import com.InventoryManagement.order_service.ForiegnDTO.OrderItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order-item-service") // Service name registered in Eureka
public interface OrderItemClient {

    @GetMapping("/order-items/order/{orderId}")
    List<OrderItemDTO> getItemsByOrderId(@PathVariable("orderId") Long orderId);
}

