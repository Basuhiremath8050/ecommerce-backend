package com.ecommerce.userservice.controller;

import com.ecommerce.userservice.dto.ProductDto;
import com.ecommerce.userservice.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
}
