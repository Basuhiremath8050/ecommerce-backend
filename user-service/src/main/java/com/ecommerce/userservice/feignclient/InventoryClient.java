package com.ecommerce.userservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory-service")
public interface InventoryClient {
@GetMapping("/check")
boolean isInStock(@RequestParam Long productId,@RequestParam int quantity);
@GetMapping
String reduceStock(@RequestParam Long productId,@RequestParam int quantity);
}
