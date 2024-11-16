package com.example.nandini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.nandini.model.Restaurant;
import com.example.nandini.repository.RestaurantRepository;

public class RestaurantService {
	
	 @Autowired
	    private RestaurantRepository restaurantRepository;

	    public Restaurant createRestaurant(Restaurant restaurant) {
	        return restaurantRepository.save(restaurant);
	    }

	    public Restaurant updateRestaurant(String restaurantId, Restaurant updatedDetails) {
	        Restaurant restaurant = restaurantRepository.findById(restaurantId)
	                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
	        restaurant.setName(updatedDetails.getName());
	        restaurant.setAddress(updatedDetails.getAddress());
	        restaurant.setCuisine(updatedDetails.getCuisine());
	        restaurant.setDeliveryZones(updatedDetails.getDeliveryZones());
	        restaurant.setOperatingHours(updatedDetails.getOperatingHours());
	        return restaurantRepository.save(restaurant);
	    }

	    public void deleteRestaurant(String restaurantId) {
	        Restaurant restaurant = restaurantRepository.findById(restaurantId)
	                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
	        restaurantRepository.delete(restaurant);
	    }

	    public Restaurant getRestaurantById(String restaurantId) {
	        return restaurantRepository.findById(restaurantId)
	                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
	    }

	    public List<Restaurant> getAllRestaurants() {
	        return restaurantRepository.findAll();
	    }

	    public List<Restaurant> getRestaurantsByOwnerId(String ownerId) {
	        return restaurantRepository.findByOwnerId(ownerId);
	    }

}
