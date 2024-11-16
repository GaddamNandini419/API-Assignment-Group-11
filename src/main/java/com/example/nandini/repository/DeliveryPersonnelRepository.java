package com.example.nandini.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.nandini.model.DeliveryPersonnel;

public interface DeliveryPersonnelRepository extends MongoRepository<DeliveryPersonnel, String> {
    // Custom query methods if needed
}
