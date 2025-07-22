package com.ecommerce.userservice.service;

import com.ecommerce.userservice.dto.OrderPlacedEvent;
import com.ecommerce.userservice.dto.OrderRequest;
import com.ecommerce.userservice.dto.ProductDto;
import com.ecommerce.userservice.feignclient.InventoryClient;
import com.ecommerce.userservice.feignclient.ProductClient;
import com.ecommerce.userservice.kafka.OrderProducer;
import com.ecommerce.userservice.model.Order;
import com.ecommerce.userservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class  OrderService {
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final OrderProducer orderProducer;



    public OrderService(ProductClient productClient, OrderRepository orderRepository, InventoryClient inventoryClient, OrderProducer orderProducer) {
        this.productClient = productClient;
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
        this.orderProducer = orderProducer;
    }
    public ProductDto fetchProductDetails(Long id) {
        return productClient.getProductById(id);
    }
    public Order placeOrder(OrderRequest request, String userEmail) {
        ProductDto product = productClient.getProductById(request.getProductId());


        boolean inStock = inventoryClient.isInStock(product.getId(), request.getQuantity());
        if (!inStock) {
            throw new RuntimeException("Not enough stock for product: " + product.getName());
        }
        String res = inventoryClient.reduceStock(product.getId(), request.getQuantity());
        System.out.println("res = " + res);
        Order order = Order.builder()
                .productId(product.getId())
                .productName(product.getName())
                .quantity(request.getQuantity())
                .totalPrice(product.getPrice() * request.getQuantity())
                .email(userEmail)
                .build();
        orderProducer.sendOrderPlacedEvent(
                new OrderPlacedEvent(order.getId(), order.getEmail(), order.getTotalPrice())
        );
        return orderRepository.save(order);


    }
}
