package com.InventoryManagement.orderItem_service.Service;



import com.InventoryManagement.orderItem_service.DTO.OrderItemDTO;

import java.util.List;

public interface OrderItemService {
    OrderItemDTO createOrderItem(OrderItemDTO dto);
    List<OrderItemDTO> getItemsByOrderId(Long orderId);
    List<OrderItemDTO> createOrderItemFromOrders(List<OrderItemDTO> dto);
}

