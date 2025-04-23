package com.InventoryManagement.order_service.Service;

import com.InventoryManagement.order_service.ForiegnDTO.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderEventPublisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "email-topic";

    public void sendOrderEvent(Long orderId, Long customerId) {
        String combined = orderId + ":" + customerId;
        kafkaTemplate.send(TOPIC, combined);
    }
}
