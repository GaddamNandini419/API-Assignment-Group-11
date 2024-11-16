package com.example.nandini.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.nandini.model.Restaurant;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

	List<Restaurant> findByNameContaining(String name);
	Optional<Restaurant> findById(String restaurantId);
	List<Restaurant> findByOwnerId(String ownerId);
}
