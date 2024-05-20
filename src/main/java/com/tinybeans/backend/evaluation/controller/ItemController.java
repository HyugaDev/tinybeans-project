package com.tinybeans.backend.evaluation.controller;

import com.tinybeans.backend.evaluation.data.entity.Item;
import com.tinybeans.backend.evaluation.service.IItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for managing items.
 *
 * This controller provides endpoints for retrieving item information.
 * The {@code @RestController} annotation marks this class as a REST controller,
 * and {@code @RequestMapping} sets the base URL for all endpoints in this controller.
 * {@code @RequiredArgsConstructor} is used to generate a constructor with required arguments.
 *
 * @version 1.0
 * @since 2024-05-18
 * @author Anna Mack
 */

@RestController @RequiredArgsConstructor
@RequestMapping("/api/v1/items")
public class ItemController {
    private final IItemService itemService;


    /**
     * Retrieve all items.
     * This endpoint allows cross-origin requests from any origin.
     *
     * @return a list of all items.
     */
    @GetMapping @CrossOrigin(origins = "*")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    /**
     * Retrieve an item by its ID.
     * This endpoint allows retrieving a single item based on its unique identifier.
     *
     * @param id the ID of the item to retrieve.
     * @return the item with the specified ID.
     */

    @GetMapping("/{id}") @CrossOrigin(origins = "*")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

}
