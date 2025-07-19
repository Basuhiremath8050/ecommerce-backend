package com.ecommerce.product_service;

import com.ecommerce.product_service.model.Product;
import com.ecommerce.product_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(ProductRepository productRepository) {
        return args -> {
            productRepository.saveAll(List.of(
                    Product.builder().name("iPhone 14").description("Apple smartphone").price(79999.0).build(),
                    Product.builder().name("Samsung Galaxy S23").description("Samsung flagship").price(74999.0).build(),
                    Product.builder().name("OnePlus 11").description("Premium OnePlus device").price(59999.0).build(),
                    Product.builder().name("MacBook Pro").description("Apple laptop").price(159999.0).build(),
                    Product.builder().name("Dell XPS 13").description("Ultrabook laptop").price(139999.0).build(),
                    Product.builder().name("iPad Air").description("Apple tablet").price(49999.0).build(),
                    Product.builder().name("Sony WH-1000XM5").description("Noise-cancelling headphones").price(29999.0).build(),
                    Product.builder().name("Logitech MX Master 3").description("Ergonomic mouse").price(9999.0).build(),
                    Product.builder().name("Samsung 4K Monitor").description("Ultra HD monitor").price(27999.0).build(),
                    Product.builder().name("Canon EOS 1500D").description("DSLR camera").price(41999.0).build()
            ));
        };
    }
}