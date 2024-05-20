package com.tinybeans.backend.evaluation.controller;

import com.tinybeans.backend.evaluation.data.entity.Item;
import com.tinybeans.backend.evaluation.data.entity.Product;
import com.tinybeans.backend.evaluation.service.IProductService;
import lombok.RequiredArgsConstructor;
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
 * @since 2024-05-20
 * @author Anna Mack
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final IProductService productService;
    /**
     * Return all the products.
     * This endpoint allows the creation of a new order.
     *
     * @return the list of all products.
     */
    @GetMapping
    @CrossOrigin(origins = "*")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    /**
     * Retrieve a Product by its ID.
     * This endpoint allows retrieving a single item based on its unique identifier.
     *
     * @param id the ID of the item to retrieve.
     * @return the item with the specified ID.
     */
    @GetMapping("/{id}") @CrossOrigin(origins = "*")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
