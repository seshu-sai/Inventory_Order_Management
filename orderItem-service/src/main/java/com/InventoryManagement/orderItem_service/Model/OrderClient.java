package com.InventoryManagement.orderItem_service.Model;

import com.InventoryManagement.orderItem_service.ForiegnDTO.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "order-service")
public interface OrderClient {

    @GetMapping("/api/orders/{id}")
    OrderDTO getOrderById(@PathVariable("id") Long id);

    @PostMapping("/api/orders")
    OrderDTO createOrder(@RequestBody OrderDTO orderDTO);
}

