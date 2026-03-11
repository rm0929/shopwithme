package com.shopwithme.catalog.services;


import com.shopwithme.catalog.models.Product;
import com.shopwithme.catalog.services.interfaces.IProductService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

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
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Product> getAllProducts() {

        try {

            ClassPathResource resource = new ClassPathResource("data/products.json");
            InputStream inputStream = resource.getInputStream();

            return objectMapper.readValue(inputStream, new TypeReference<List<Product>>() {});

        } catch (Exception e) {
            throw new RuntimeException("Failed to load product data", e);
        }
    }
}