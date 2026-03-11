package com.shopwithme.catalog.services;

import com.shopwithme.catalog.models.Product;
import com.shopwithme.catalog.repository.interfaces.IProductRepository;
import com.shopwithme.catalog.services.interfaces.IProductService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Copyright (c) 2026 OmegaEcommerce
 * <p>
 * Class: ProductService
 * <p>
 * Description:
 * ------------------------------------------------
 * Provides product data for the catalog service.
 */
@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(UUID id) {
        return productRepository.findById(id);
    }


}