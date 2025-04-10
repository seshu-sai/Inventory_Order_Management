package com.InventoryManagement.order_service.Model;

import com.InventoryManagement.order_service.ForiegnDTO.OrderItemDTO;
import jakarta.persistence.Entity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "orderItem-service") // Service name registered in Eureka
public interface OrderItemClient {

    @GetMapping("/order-items/order/{orderId}")
    List<OrderItemDTO> getItemsByOrderId(@PathVariable("orderId") Long orderId);


        @PostMapping("/api/order-items/orders")
        List<OrderItemDTO> createItemFromOrders(@RequestBody List<OrderItemDTO> dto);


}

