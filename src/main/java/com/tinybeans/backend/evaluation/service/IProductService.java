package com.tinybeans.backend.evaluation.service;

import com.tinybeans.backend.evaluation.data.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
}
