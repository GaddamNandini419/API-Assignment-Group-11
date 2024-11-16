package com.example.nandini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.nandini.model.RestaurantOwner;
import com.example.nandini.service.RestaurantOwnerService;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant-owner")
public class RestaurantOwnerController {

    @Autowired
    private RestaurantOwnerService restaurantOwnerService;

    // Create Restaurant Owner
    @PostMapping
    public ResponseEntity<RestaurantOwner> createRestaurantOwner(@RequestBody RestaurantOwner owner) {
        RestaurantOwner createdOwner = restaurantOwnerService.createRestaurantOwner(owner);
        return ResponseEntity.ok(createdOwner);
    }

    // Get All Restaurant Owners
    @GetMapping
    public ResponseEntity<List<RestaurantOwner>> getAllRestaurantOwners() {
        return ResponseEntity.ok(restaurantOwnerService.getAllRestaurantOwners());
    }

    // Get Restaurant Owner by ID
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantOwner> getRestaurantOwnerById(@PathVariable String id) {
        return ResponseEntity.ok(restaurantOwnerService.getRestaurantOwnerById(id));
    }

    // Update Restaurant Owner
    @PutMapping("/{id}")
    public ResponseEntity<RestaurantOwner> updateRestaurantOwner(@PathVariable String id, @RequestBody RestaurantOwner updatedOwner) {
        return ResponseEntity.ok(restaurantOwnerService.updateRestaurantOwner(id, updatedOwner));
    }

    // Delete Restaurant Owner
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurantOwner(@PathVariable String id) {
        restaurantOwnerService.deleteRestaurantOwner(id);
        return ResponseEntity.noContent().build();
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        if (restaurantOwnerService.login(email, password)) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
