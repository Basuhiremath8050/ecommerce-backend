//package com.ecommerce.inventory_service.repository;
//
//import com.ecommerce.inventory_service.model.Inventory;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class InventoryDataLoader {
//    private final InventoryRepository inventoryRepository;
//
//    @PostConstruct
//    public void init() {
//        List<Inventory> initialInventory = List.of(
//                Inventory.builder().productId(1L).quantity(100).build(),
//                Inventory.builder().productId(2L).quantity(50).build(),
//                Inventory.builder().productId(3L).quantity(80).build(),
//                Inventory.builder().productId(4L).quantity(25).build(),
//                Inventory.builder().productId(5L).quantity(60).build(),
//                Inventory.builder().productId(6L).quantity(40).build(),
//                Inventory.builder().productId(7L).quantity(30).build(),
//                Inventory.builder().productId(8L).quantity(70).build(),
//                Inventory.builder().productId(9L).quantity(90).build(),
//                Inventory.builder().productId(10L).quantity(55).build()
//        );
//
//        inventoryRepository.saveAll(initialInventory);
//    }
//}
//
