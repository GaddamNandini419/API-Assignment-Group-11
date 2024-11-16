package com.example.nandini.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



	@Document(collection = "customers")
	public class Customer {
	    @Id
	    private String id;
	    private String username;
	    private String password;
	    private String role; // customer, restaurant, delivery
	    private String name;
	    private String address;
	    private String paymentDetails;
	    
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPaymentDetails() {
			return paymentDetails;
		}
		public void setPaymentDetails(String paymentDetails) {
			this.paymentDetails = paymentDetails;
		}

	    // Getters and Setters
	    
	    
	    
	    
	}
	

