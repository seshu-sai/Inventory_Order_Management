package com.InventoryManagement.orderItem_service.Service;


import com.InventoryManagement.orderItem_service.DTO.OrderItemDTO;
import com.InventoryManagement.orderItem_service.Model.OrderItem;
import com.InventoryManagement.orderItem_service.Repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    @Override
    public OrderItemDTO createOrderItem(OrderItemDTO dto) {
        OrderItem item = new OrderItem();
        item.setQuantity(dto.getQuantity());
        item.setUnitPrice(dto.getUnitPrice());
        item.setTotalPrice(dto.getQuantity() * dto.getUnitPrice());
        item.setOrderId(dto.getOrderId());
        item.setProductId(dto.getProductId());

        OrderItem saved = repository.save(item);
        dto.setId(saved.getId());
        dto.setTotalPrice(saved.getTotalPrice());
        return dto;
    }

    @Override
    public List<OrderItemDTO> getItemsByOrderId(Long orderId) {
        return repository.findByOrderId(orderId).stream().map(item -> {
            OrderItemDTO dto = new OrderItemDTO();
            dto.setId(item.getId());
            dto.setQuantity(item.getQuantity());
            dto.setUnitPrice(item.getUnitPrice());
            dto.setTotalPrice(item.getTotalPrice());
            dto.setOrderId(item.getOrderId());
            dto.setProductId(item.getProductId());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<OrderItemDTO> createOrderItemFromOrders(List<OrderItemDTO> dto) {
        for (OrderItemDTO item : dto) {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(item.getQuantity());
            orderItem.setUnitPrice(item.getUnitPrice());
            orderItem.setTotalPrice(item.getQuantity() * item.getUnitPrice());
            orderItem.setOrderId(item.getOrderId());
            orderItem.setProductId(item.getProductId());
            OrderItem saved = repository.save(orderItem);
            item.setId(saved.getId());
            item.setTotalPrice(saved.getTotalPrice());
        }
        return dto;
    }
}

