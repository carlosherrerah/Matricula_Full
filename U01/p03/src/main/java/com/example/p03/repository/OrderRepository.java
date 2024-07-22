package com.example.p03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.p03.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  
}
