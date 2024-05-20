package com.tinybeans.backend.evaluation.service.Impl;

import com.tinybeans.backend.evaluation.data.entity.Item;
import com.tinybeans.backend.evaluation.repository.ItemRepository;
import com.tinybeans.backend.evaluation.service.IItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing items.
 * This service provides methods for retrieving {@link Item} entities.
 * The {@code @Service} annotation marks this class as a Spring service component.
 * The {@code @RequiredArgsConstructor} annotation generates a constructor with required arguments.
 *
 * @version 1.0
 * @since 2024-05-18
 * @author Anna Mack
 */

@RequiredArgsConstructor @Service
public class ItemServiceImpl implements IItemService {
    private final ItemRepository itemRepository;


    /**
     * Retrieve all items.
     * This method fetches all items from the database.
     *
     * @return a list of all items.
     */
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }


    /**
     * Retrieve an item by its ID.
     * This method fetches an item based on its unique identifier.
     *
     * @param id the ID of the item to retrieve.
     * @return the item with the specified ID, or {@code null} if no such item exists.
     */
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }
}
