package com.ecommerce.userservice.feignclient;

import com.ecommerce.userservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", configuration = FeignClientConfig.class)
public interface ProductClient {
@GetMapping("/api/products/{id}")
ProductDto getProductById(@PathVariable("id") Long productId);
}
