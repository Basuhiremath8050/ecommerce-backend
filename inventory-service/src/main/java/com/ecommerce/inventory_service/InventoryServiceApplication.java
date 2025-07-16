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

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

@Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {

        return args -> {
            inventoryRepository.saveAll(
                    List.of(
                            Inventory.builder()
                                    .quantity(10)
                                    .productId(1L)
                                    .build(),
                            Inventory.builder()
                                    .quantity(10)
                                    .productId(2L)
                                    .build(),
                            Inventory.builder()
                                    .quantity(0)
                                    .productId(3L)
                                    .build()
                    )

            );
        };

    }
}
