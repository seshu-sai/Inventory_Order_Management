package com.InventoryManagement.order_service.Service;


import com.InventoryManagement.order_service.DTO.OrderDTO;
import com.InventoryManagement.order_service.Model.OrderItemClient;
import com.InventoryManagement.order_service.Model.ProductClient;
import com.InventoryManagement.order_service.Repository.OrderRepository;
import com.InventoryManagement.order_service.ForiegnDTO.OrderItemDTO;
import com.InventoryManagement.order_service.Model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    OrderItemClient orderItemClient;


    @Autowired
    OrderEventPublisher orderEventPublisher;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");
        order.setCustomerId(orderDTO.getCustomerId());
        order.setTotalAmount(orderDTO.getTotalAmount());

        Order savedOrder = orderRepository.save(order);



        List<OrderItemDTO> itemsWithOrderId = orderDTO.getItems().stream()
                .peek(item -> {item.setOrderId(savedOrder.getId());
                })
                .collect(Collectors.toList());

        List<OrderItemDTO> savedItems = orderItemClient.createItemFromOrders(itemsWithOrderId);
        OrderDTO result = modelMapper.map(savedOrder, OrderDTO.class);
        result.setItems(savedItems);
        orderEventPublisher.sendOrderEvent(savedOrder.getId(), savedOrder.getCustomerId());
        return result;
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return modelMapper.map(order, OrderDTO.class);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

