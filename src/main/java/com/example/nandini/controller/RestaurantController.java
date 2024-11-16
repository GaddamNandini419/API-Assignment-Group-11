package com.example.nandini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nandini.model.Restaurant;
import com.example.nandini.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	    @Autowired
	    private RestaurantService restaurantService;

	    // Create a new restaurant
	    @PostMapping
	    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
	        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdRestaurant);
	    }

	    // Update an existing restaurant by ID
	    @PutMapping("/{restaurantId}")
	    public ResponseEntity<Restaurant> updateRestaurant(
	            @PathVariable String restaurantId,
	            @RequestBody Restaurant updatedDetails) {
	        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurantId, updatedDetails);
	        return ResponseEntity.ok(updatedRestaurant);
	    }

	    // Delete a restaurant by ID
	    @DeleteMapping("/{restaurantId}")
	    public ResponseEntity<Void> deleteRestaurant(@PathVariable String restaurantId) {
	        restaurantService.deleteRestaurant(restaurantId);
	        return ResponseEntity.noContent().build();
	    }

	    // Get a specific restaurant by ID
	    @GetMapping("/{restaurantId}")
	    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable String restaurantId) {
	        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
	        return ResponseEntity.ok(restaurant);
	    }

	    // Get all restaurants
	    @GetMapping
	    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
	        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
	        return ResponseEntity.ok(restaurants);
	    }

	    // Get restaurants by owner ID
	    @GetMapping("/owner/{ownerId}")
	    public ResponseEntity<List<Restaurant>> getRestaurantsByOwnerId(@PathVariable String ownerId) {
	        List<Restaurant> restaurants = restaurantService.getRestaurantsByOwnerId(ownerId);
	        return ResponseEntity.ok(restaurants);
	    }
}
