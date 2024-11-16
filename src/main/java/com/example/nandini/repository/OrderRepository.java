package com.example.nandini.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.nandini.model.Order;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    // Find all orders by customerId
    List<Order> findByCustomerId(Long customerId);

    // Find all orders by restaurantId
    List<Order> findByRestaurantId(Long restaurantId);

    // Find orders by their status
    List<Order> findByStatus(String status);
}
