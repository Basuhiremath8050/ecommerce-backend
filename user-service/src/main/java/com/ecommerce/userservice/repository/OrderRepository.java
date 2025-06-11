package com.ecommerce.userservice.repository;

import com.ecommerce.userservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
