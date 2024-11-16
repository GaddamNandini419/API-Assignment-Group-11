package com.example.nandini.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.nandini.model.Customer;
import com.example.nandini.model.Restaurant;
import com.example.nandini.repository.CustomerRepository;
import com.example.nandini.repository.RestaurantRepository;
import com.example.nandini.security.JwtUtil;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
	
 @Autowired
 private  CustomerRepository customerRepository;
 
 @Autowired
 private  RestaurantRepository restaurantRepository;
 

 public Customer registerUser(Customer customer) {
     return customerRepository.save(customer);
 }

 public String  loginUser(String username, String password) {
     Optional<Customer> customer = customerRepository.findByUsername(username);
     if (customer.isPresent() && password.equals(customer.get().getPassword())) {
         return JwtUtil.generateToken(username);
     }
     return null;
 }

public  void deleteCustomer(String id) {
	customerRepository.deleteById(id);
	
}

public Customer updateCustomer(String id, Customer updatedCustomer) {
    // Check if the customer exists
    Optional<Customer> existingCustomer = customerRepository.findById(id);
    if (existingCustomer.isPresent()) {
        // Update fields
        Customer customer = existingCustomer.get();
        customer.setName(updatedCustomer.getName());
        // Update other fields as necessary
        return customerRepository.save(customer);
    }
    return null; // or throw an exception
}

public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
}


	public List<Restaurant> getAllRestaurants() {
	    return restaurantRepository.findAll();
	}



}

