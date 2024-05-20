package com.tinybeans.backend.evaluation.service;

import com.tinybeans.backend.evaluation.data.entity.Item;
import com.tinybeans.backend.evaluation.data.entity.Orders;

import java.util.List;

public interface IOrderService {
    Orders getOrderById(Long id);
    Long createOrder(Orders order);
    List<Item> getAllOrderItems(Long id);
}
