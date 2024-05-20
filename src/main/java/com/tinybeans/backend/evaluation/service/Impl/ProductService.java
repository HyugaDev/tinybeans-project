package com.tinybeans.backend.evaluation.service.Impl;

import com.tinybeans.backend.evaluation.data.entity.Product;
import com.tinybeans.backend.evaluation.repository.ProductRepository;
import com.tinybeans.backend.evaluation.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing products.
 * This class implements the IProductService interface and provides methods to interact with the ProductRepository.
 * It is annotated with @Service to indicate it's a Spring service component and @RequiredArgsConstructor for dependency injection.
 */
@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    /**
     * Retrieves all products from the repository.
     *
     * @return a list of all products.
     */    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieves a product by its unique identifier.
     *
     * @param id the unique identifier of the product.
     * @return the product with the specified id.
     */
    @Override
    public Product getProductById(Long id) {
        return productRepository.getById(id);
    }
}
