package com.example.nandini.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.nandini.model.RestaurantOwner;

import java.util.Optional;

public interface RestaurantOwnerRepository extends MongoRepository<RestaurantOwner, String> {
    Optional<RestaurantOwner> findByEmail(String email);
}
