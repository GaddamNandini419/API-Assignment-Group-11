package com.example.nandini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nandini.model.DeliveryPersonnel;
import com.example.nandini.repository.DeliveryPersonnelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryPersonnelService {

    @Autowired
    private DeliveryPersonnelRepository deliveryPersonnelRepository;

    // Create Delivery Personnel
    public DeliveryPersonnel createDeliveryPersonnel(DeliveryPersonnel deliveryPersonnel) {
        return deliveryPersonnelRepository.save(deliveryPersonnel);
    }

    // Get All Delivery Personnel
    public List<DeliveryPersonnel> getAllDeliveryPersonnel() {
        return deliveryPersonnelRepository.findAll();
    }

    // Get Delivery Personnel by ID
    public DeliveryPersonnel getDeliveryPersonnelById(String id) {
        return deliveryPersonnelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery personnel not found with ID: " + id));
    }

    // Update Delivery Personnel
    public DeliveryPersonnel updateDeliveryPersonnel(String id, DeliveryPersonnel updatedPersonnel) {
        return deliveryPersonnelRepository.findById(id)
                .map(existingPersonnel -> {
                    existingPersonnel.setName(updatedPersonnel.getName());
                    existingPersonnel.setPhoneNumber(updatedPersonnel.getPhoneNumber());
                    existingPersonnel.setEmail(updatedPersonnel.getEmail());
                    existingPersonnel.setVehicleDetails(updatedPersonnel.getVehicleDetails());
                    existingPersonnel.setStatus(updatedPersonnel.getStatus());
                    return deliveryPersonnelRepository.save(existingPersonnel);
                })
                .orElseThrow(() -> new RuntimeException("Delivery personnel not found with ID: " + id));
    }

    // Delete Delivery Personnel
    public void deleteDeliveryPersonnel(String id) {
        deliveryPersonnelRepository.deleteById(id);
    }
}
