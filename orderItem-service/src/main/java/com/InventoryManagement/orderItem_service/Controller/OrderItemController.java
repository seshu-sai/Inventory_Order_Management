package com.InventoryManagement.orderItem_service.Controller;


import com.InventoryManagement.orderItem_service.DTO.OrderItemDTO;
import com.InventoryManagement.orderItem_service.Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService service;

    @PostMapping
    public OrderItemDTO createItem(@RequestBody OrderItemDTO dto) {
        return service.createOrderItem(dto);
    }

    @PostMapping("/orders")
    public List<OrderItemDTO> createItemFromOrders(@RequestBody List<OrderItemDTO> dto) {
        return service.createOrderItemFromOrders(dto);
    }


    @GetMapping("/order/{orderId}")
    public List<OrderItemDTO> getItemsByOrder(@PathVariable Long orderId) {
        return service.getItemsByOrderId(orderId);
    }
}

