package com.example.nandini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.nandini.model.DeliveryPersonnel;
import com.example.nandini.service.DeliveryPersonnelService;

import java.util.List;

@RestController
@RequestMapping("/api/admin/delivery-personnel")
public class DeliveryPersonnelController {

    @Autowired
    private DeliveryPersonnelService deliveryPersonnelService;

    // Create Delivery Personnel
    @PostMapping
    public ResponseEntity<DeliveryPersonnel> createDeliveryPersonnel(@RequestBody DeliveryPersonnel deliveryPersonnel) {
        DeliveryPersonnel createdPersonnel = deliveryPersonnelService.createDeliveryPersonnel(deliveryPersonnel);
        return ResponseEntity.ok(createdPersonnel);
    }

    // Get All Delivery Personnel
    @GetMapping
    public ResponseEntity<List<DeliveryPersonnel>> getAllDeliveryPersonnel() {
        return ResponseEntity.ok(deliveryPersonnelService.getAllDeliveryPersonnel());
    }

    // Get Delivery Personnel by ID
    @GetMapping("/{id}")
    public ResponseEntity<DeliveryPersonnel> getDeliveryPersonnelById(@PathVariable String id) {
        return ResponseEntity.ok(deliveryPersonnelService.getDeliveryPersonnelById(id));
    }

    // Update Delivery Personnel
    @PutMapping("/{id}")
    public ResponseEntity<DeliveryPersonnel> updateDeliveryPersonnel(@PathVariable String id, @RequestBody DeliveryPersonnel updatedPersonnel) {
        return ResponseEntity.ok(deliveryPersonnelService.updateDeliveryPersonnel(id, updatedPersonnel));
    }

    // Delete Delivery Personnel
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliveryPersonnel(@PathVariable String id) {
        deliveryPersonnelService.deleteDeliveryPersonnel(id);
        return ResponseEntity.noContent().build();
    }
}
