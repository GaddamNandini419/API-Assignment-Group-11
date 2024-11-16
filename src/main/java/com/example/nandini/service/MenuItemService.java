package com.example.nandini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nandini.model.MenuItem;
import com.example.nandini.repository.MenuItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    // Create a Menu Item
    public MenuItem createMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    // Get All Menu Items
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    // Get Menu Items by Restaurant
    public List<MenuItem> getMenuItemsByRestaurant(String restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId);
    }

    // Get Menu Item by ID
    public MenuItem getMenuItemById(String id) {
        return menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu Item not found with ID: " + id));
    }

    // Update Menu Item
    public MenuItem updateMenuItem(String id, MenuItem updatedItem) {
        return menuItemRepository.findById(id)
                .map(existingItem -> {
                    existingItem.setName(updatedItem.getName());
                    existingItem.setDescription(updatedItem.getDescription());
                    existingItem.setPrice(updatedItem.getPrice());
                    existingItem.setCategory(updatedItem.getCategory());
                    existingItem.setAvailable(updatedItem.isAvailable());
                    return menuItemRepository.save(existingItem);
                })
                .orElseThrow(() -> new RuntimeException("Menu Item not found with ID: " + id));
    }

    // Delete Menu Item
    public void deleteMenuItem(String id) {
        menuItemRepository.deleteById(id);
    }
}
