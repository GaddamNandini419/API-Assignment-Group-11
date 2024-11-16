package com.example.nandini.repository;


	import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.nandini.model.Customer;

import java.util.Optional;

	public interface CustomerRepository extends MongoRepository<Customer, String> {
	    Optional<Customer> findByUsername(String username);
	}



