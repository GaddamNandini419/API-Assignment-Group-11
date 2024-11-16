package com.example.nandini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.nandini.model.MenuItem;
import com.example.nandini.service.MenuItemService;

import java.util.List;

@RestController
@RequestMapping("/api/menu-item")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    // Create Menu Item
    @PostMapping
    public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItem menuItem) {
        MenuItem createdItem = menuItemService.createMenuItem(menuItem);
        return ResponseEntity.ok(createdItem);
    }

    // Get All Menu Items
    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        return ResponseEntity.ok(menuItemService.getAllMenuItems());
    }

    // Get Menu Items by Restaurant
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<MenuItem>> getMenuItemsByRestaurant(@PathVariable String restaurantId) {
        return ResponseEntity.ok(menuItemService.getMenuItemsByRestaurant(restaurantId));
    }

    // Get Menu Item by ID
    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable String id) {
        return ResponseEntity.ok(menuItemService.getMenuItemById(id));
    }

    // Update Menu Item
    @PutMapping("/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable String id, @RequestBody MenuItem updatedItem) {
        return ResponseEntity.ok(menuItemService.updateMenuItem(id, updatedItem));
    }

    // Delete Menu Item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable String id) {
        menuItemService.deleteMenuItem(id);
        return ResponseEntity.noContent().build();
    }
}
