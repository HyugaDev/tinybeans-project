package com.tinybeans.backend.evaluation.service.Impl;

import com.tinybeans.backend.evaluation.data.entity.Item;
import com.tinybeans.backend.evaluation.data.entity.Orders;
import com.tinybeans.backend.evaluation.repository.ItemRepository;
import com.tinybeans.backend.evaluation.repository.OrderRepository;
import com.tinybeans.backend.evaluation.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing orders.
 *
 * This service provides methods for saving and retrieving {@link Orders} entities,
 * and handles payment processing through Stripe.
 * The {@code @Service} annotation marks this class as a Spring service component.
 * The {@code @RequiredArgsConstructor} annotation generates a constructor with required arguments.
 *
 * @version 1.0
 * @since 2024-05-18
 * @author Anna Mack
 */

@RequiredArgsConstructor @Service
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    /**
     * Retrieve an order by its ID.
     * This method fetches an order based on its unique identifier.
     *
     * @param id the ID of the order to retrieve.
     * @return the order with the specified ID, or {@code null} if no such order exists.
     */
    public Orders getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new order and saves it to the repository.
     *
     * @param order the order to be created and saved
     * @return the ID of the newly created order
     */
    @Override
    public Long createOrder(Orders order) {
        orderRepository.save(order);
        return order.getId();
    }

    /**
     * Retrieves all items associated with a given order ID.
     *
     * @param id the ID of the order whose items are to be retrieved
     * @return a list of items belonging to the specified order
     */
    @Override
    public List<Item> getAllOrderItems(Long id) {
        return itemRepository.findByOrdersId(id);
    }

}
