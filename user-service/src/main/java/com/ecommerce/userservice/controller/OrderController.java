package com.ecommerce.userservice.controller;

import com.ecommerce.userservice.dto.OrderRequest;
import com.ecommerce.userservice.dto.ProductDto;
import com.ecommerce.userservice.model.Order;
import com.ecommerce.userservice.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
@Tag(name = "Order", description = "Fetch product details via order service")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/product/{id}")
    public ProductDto getProductDetails(@PathVariable Long id) {
        return orderService.fetchProductDetails(id);
    }

    @PostMapping("/place")
    public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest request, Authentication authentication) {
        String userEmail = authentication.getName();
        Order order = orderService.placeOrder(request, userEmail);
        return ResponseEntity.ok(order);
    }
}
