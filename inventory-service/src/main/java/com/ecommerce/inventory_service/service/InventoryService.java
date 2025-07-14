package com.ecommerce.inventory_service.service;

import com.ecommerce.inventory_service.model.Inventory;
import com.ecommerce.inventory_service.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    public boolean isInStock(Long productId,int quantity){
        Optional<Inventory> inventoryOptional = inventoryRepository.findByProductId(productId);
        return inventoryOptional.map(inventory ->
            inventory.getQuantity()>=quantity).orElse(false);
    }
    public void reduceStock(Long productId,int quantity) {
        Inventory inInventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Product not found in inventory"));
        if (inInventory.getQuantity() < quantity) {
            throw new RuntimeException("Not enough stock for productId " + productId);
        }
        inInventory.setQuantity(inInventory.getQuantity() - quantity);
        inventoryRepository.save(inInventory);
    }
    }

