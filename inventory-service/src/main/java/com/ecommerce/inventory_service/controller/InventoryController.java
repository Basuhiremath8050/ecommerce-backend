package com.ecommerce.inventory_service.controller;

import com.ecommerce.inventory_service.service.InventoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Inventory",description = "Manage product inventory")
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping("/check")
    public ResponseEntity<Boolean>isInStock(
            @RequestParam Long productId,
            @RequestParam int quantity
    ){
return ResponseEntity.ok(inventoryService.isInStock(productId,quantity));
    }
    @GetMapping("/reduce")
    public ResponseEntity<String>reduceStock(
            @RequestParam Long productId,
            @RequestParam int quantity
    ){
        inventoryService.reduceStock(productId,quantity);
        return ResponseEntity.ok("Stock reduced successfully");
    }
}
