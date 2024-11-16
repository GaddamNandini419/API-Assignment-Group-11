package com.example.nandini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nandini.model.RestaurantOwner;
import com.example.nandini.repository.RestaurantOwnerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantOwnerService {

    @Autowired
    private RestaurantOwnerRepository restaurantOwnerRepository;

    // Create Restaurant Owner
    public RestaurantOwner createRestaurantOwner(RestaurantOwner owner) {
        return restaurantOwnerRepository.save(owner);
    }

    // Get All Restaurant Owners
    public List<RestaurantOwner> getAllRestaurantOwners() {
        return restaurantOwnerRepository.findAll();
    }

    // Get Restaurant Owner by ID
    public RestaurantOwner getRestaurantOwnerById(String id) {
        return restaurantOwnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant Owner not found with ID: " + id));
    }

    // Update Restaurant Owner
    public RestaurantOwner updateRestaurantOwner(String id, RestaurantOwner updatedOwner) {
        return restaurantOwnerRepository.findById(id)
                .map(existingOwner -> {
                    existingOwner.setName(updatedOwner.getName());
                    existingOwner.setPhoneNumber(updatedOwner.getPhoneNumber());
                    existingOwner.setEmail(updatedOwner.getEmail());
                    existingOwner.setPassword(updatedOwner.getPassword());
                    return restaurantOwnerRepository.save(existingOwner);
                })
                .orElseThrow(() -> new RuntimeException("Restaurant Owner not found with ID: " + id));
    }

    // Delete Restaurant Owner
    public void deleteRestaurantOwner(String id) {
        restaurantOwnerRepository.deleteById(id);
    }

    // Login Restaurant Owner
    public boolean login(String email, String password) {
        Optional<RestaurantOwner> owner = restaurantOwnerRepository.findByEmail(email);
        return owner.isPresent() && owner.get().getPassword().equals(password);
    }
}
