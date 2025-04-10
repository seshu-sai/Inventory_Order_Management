package com.InventoryManagement.order_service.Service;

import com.InventoryManagement.order_service.DTO.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO);
    OrderDTO getOrderById(Long id);
    List<OrderDTO> getAllOrders();
    void deleteOrder(Long id);
}
