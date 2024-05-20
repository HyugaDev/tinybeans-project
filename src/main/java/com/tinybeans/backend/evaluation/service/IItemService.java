package com.tinybeans.backend.evaluation.service;

import com.tinybeans.backend.evaluation.data.entity.Item;

import java.util.List;

public interface IItemService {
    List<Item> getAllItems();
    Item getItemById(Long id);
}
