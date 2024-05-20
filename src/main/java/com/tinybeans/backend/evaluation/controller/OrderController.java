package com.tinybeans.backend.evaluation.controller;

import com.tinybeans.backend.evaluation.data.entity.Orders;
import com.tinybeans.backend.evaluation.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Rest Controller for managing orders.
 *
 * This controller provides endpoints for creating and retrieving order information.
 * The {@code @RestController} annotation marks this class as a REST controller,
 * and {@code @RequestMapping} sets the base URL for all endpoints in this controller.
 * {@code @RequiredArgsConstructor} is used to generate a constructor with required arguments.
 *
 * @version 1.0
 * @since 2024-05-18
 * @author Anna Mack
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final IOrderService orderService;


    /**
     * Create a new order.
     * This endpoint allows the creation of a new order.
     *
     * @param order the order object to be created.
     * @return the created order.
     */
    @PostMapping @CrossOrigin(origins = "*")
    public Long createOrder(@RequestBody Orders order) {
        return orderService.createOrder(order);
    }

    /**
     * Retrieve an order by its ID.
     * This endpoint allows retrieving a single order based on its unique identifier.
     *
     * @param id the ID of the order to retrieve.
     * @return the order with the specified ID.
     */
    @GetMapping("/{id}") @CrossOrigin(origins = "*")
    public Orders getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
