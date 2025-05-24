package com.ecommerce.userservice.service;

import com.ecommerce.userservice.dto.ProductDto;
import com.ecommerce.userservice.feignclient.ProductClient;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final ProductClient productClient;

    public OrderService(ProductClient productClient) {
        this.productClient = productClient;
    }
    public ProductDto fetchProductDetails(Long id) {
        return productClient.getProductById(id);
    }
}
