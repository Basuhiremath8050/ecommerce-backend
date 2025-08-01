package com.ecommerce.userservice.kafka;

import com.ecommerce.userservice.dto.OrderPlacedEvent;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public void sendOrderPlacedEvent(OrderPlacedEvent event) {
        kafkaTemplate.send("order-placed-topic", event);
        System.out.println(" Kafka Message sent: " + event);
    }
}
