package com.ecommerce.userservice.service;

import com.ecommerce.userservice.dto.OrderRequest;
import com.ecommerce.userservice.dto.ProductDto;
import com.ecommerce.userservice.feignclient.ProductClient;
import com.ecommerce.userservice.model.Order;
import com.ecommerce.userservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class  OrderService {
    private final ProductClient productClient;
    private final OrderRepository orderRepository;


    public OrderService(ProductClient productClient, OrderRepository orderRepository) {
        this.productClient = productClient;
        this.orderRepository = orderRepository;
    }
    public ProductDto fetchProductDetails(Long id) {
        return productClient.getProductById(id);
    }
    public Order placeOrder(OrderRequest request, String userEmail) {
        ProductDto product = productClient.getProductById(request.getProductId());

        if (product.getQuantity() < request.getQuantity()) {
            throw new RuntimeException("Not enough stock for product: " + product.getName());
        }

        Order order = Order.builder()
                .productId(product.getId())
                .productName(product.getName())
                .quantity(request.getQuantity())
                .totalPrice(product.getPrice() * request.getQuantity())
                .email(userEmail)
                .build();

        return orderRepository.save(order);
    }
}
