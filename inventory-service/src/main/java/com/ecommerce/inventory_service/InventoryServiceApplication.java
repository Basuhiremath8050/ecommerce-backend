package com.ecommerce.inventory_service;

import com.ecommerce.inventory_service.model.Inventory;
import com.ecommerce.inventory_service.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {
    //testing
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            inventoryRepository.deleteAll();;
            inventoryRepository.saveAll(List.of(
                    Inventory.builder().productId(1L).quantity(100).build(),
                    Inventory.builder().productId(2L).quantity(50).build(),
                    Inventory.builder().productId(3L).quantity(80).build(),
                    Inventory.builder().productId(4L).quantity(25).build(),
                    Inventory.builder().productId(5L).quantity(60).build(),
                    Inventory.builder().productId(6L).quantity(40).build(),
                    Inventory.builder().productId(7L).quantity(30).build(),
                    Inventory.builder().productId(8L).quantity(70).build(),
                    Inventory.builder().productId(9L).quantity(90).build(),
                    Inventory.builder().productId(10L).quantity(55).build()
            ));
        };
    }
}

