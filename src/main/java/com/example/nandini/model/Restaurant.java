package com.example.nandini.model;

import java.util.List;

// Restaurant.java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurants")
public class Restaurant {

	    @Id
	    private String id;
	    private String name;
	    private String address;
	    private String hoursOfOperation;
	    private String deliveryZone;
	    private Boolean isVeg; // true for Veg, false for Non-Veg
	    private String  Cuisine; 
	    private String OperatingHours; 
	    private String DeliveryZones;

	    private List<MenuItem> menu;
	    
	    // Association with RestaurantOwner
	    private RestaurantOwner owner;
	    
	    
	    // Constructors, Getters, and Setters
	    public Restaurant() {}

	    public Restaurant(String name, String address, String hoursOfOperation, String deliveryZone) {
	        this.name = name;
	        this.address = address;
	        this.hoursOfOperation = hoursOfOperation;
	        this.deliveryZone = deliveryZone;
	    }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
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

		public String getHoursOfOperation() {
			return hoursOfOperation;
		}

		public void setHoursOfOperation(String hoursOfOperation) {
			this.hoursOfOperation = hoursOfOperation;
		}

		public String getDeliveryZone() {
			return deliveryZone;
		}

		public void setDeliveryZone(String deliveryZone) {
			this.deliveryZone = deliveryZone;
		}

		public Boolean getIsVeg() {
			return isVeg;
		}

		public void setIsVeg(Boolean isVeg) {
			this.isVeg = isVeg;
		}

		public List<MenuItem> getMenu() {
			return menu;
		}

		public void setMenu(List<MenuItem> menu) {
			this.menu = menu;
		}

		// Getter and Setter for owner (RestaurantOwner association)
	    public RestaurantOwner getOwner() {
	        return owner;
	    }

	    public void setOwner(RestaurantOwner owner) {
	        this.owner = owner;
	    }

		public String getCuisine() {
			return Cuisine;
		}

		public void setCuisine(String cuisine) {
			Cuisine = cuisine;
		}

		public String getOperatingHours() {
			return OperatingHours;
		}

		public void setOperatingHours(String operatingHours) {
			OperatingHours = operatingHours;
		}

		public String getDeliveryZones() {
			return DeliveryZones;
		}

		public void setDeliveryZones(String deliveryZones) {
			DeliveryZones = deliveryZones;
		}

		
		

	    
	    


}
