package com.ecommerce.userservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    private String id;
    private Long productId;
    private String productName;
    private Integer quantity;
    private Double totalPrice;
    private String email;
}
