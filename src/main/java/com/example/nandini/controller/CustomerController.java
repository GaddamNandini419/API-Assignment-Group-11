package com.example.nandini.controller;

import com.example.nandini.model.Customer;
import com.example.nandini.model.Restaurant;
import com.example.nandini.model.RestaurantOwner;
import com.example.nandini.service.CustomerService;
import com.example.nandini.service.RestaurantOwnerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	private RestaurantOwnerService restaurantOwnerService;

	//register user
	@PostMapping("/register")
	public ResponseEntity<Customer> registerUser(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.registerUser(customer));
	}
    
	//login user
	@GetMapping("/login")
	public ResponseEntity<Object> loginUser(@RequestParam String username, @RequestParam String password) {
		String token =  customerService.loginUser(username, password);
		 if(token != null) {
			 return ResponseEntity.ok(token);
		 }
		 else
			 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	
	
	
	// Delete a menu item from a restaurant's menu
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
			customerService.deleteCustomer(id);
			return ResponseEntity.noContent().build(); // Return 204 No Content
		}
		
		
		//update 
		@PutMapping("/update/{id}")
	    public ResponseEntity<Customer> updateCustomer(
	            @PathVariable String id,
	            @RequestBody Customer updatedCustomer) {
	        Customer customer = customerService.updateCustomer(id, updatedCustomer);
	        if (customer != null) {
	            return ResponseEntity.ok(customer);
	        } else {
	            return ResponseEntity.notFound().build(); // Customer not found
	        }
	    }
		
		//get all customers
		@GetMapping("/getallcustomers")
	    public List<Customer> getAllCustomers() {
	        return customerService.getAllCustomers();
	    }
		
		// get all restarants
		@GetMapping("/restaurants")
	    public List<Restaurant> browseRestaurants() {
	        return customerService.getAllRestaurants();
	    }
		
}
