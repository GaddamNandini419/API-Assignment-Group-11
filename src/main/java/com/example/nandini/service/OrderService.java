package com.example.nandini.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nandini.model.Order;
import com.example.nandini.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Create a new order
    public Order createOrder(Order order) {
        order.setStatus("PENDING"); // Set initial order status
        return orderRepository.save(order);
    }

    // Get order history by customerId
    public List<Order> getOrderHistory(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    // Track a specific order by orderId
    public Optional<Order> trackOrder(String orderId) {
        return orderRepository.findById(orderId);
    }

    // Update the order status
    public Order updateOrderStatus(String orderId, String status) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}
