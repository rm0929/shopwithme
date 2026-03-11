package com.shopwithme.catalog.repository;


import com.shopwithme.catalog.models.Product;
import com.shopwithme.catalog.repository.interfaces.IProductRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Copyright (c) 2026 OmegaEcommerce
 * <p>
 * Class: ProductJsonRepository
 * <p>
 * Description:
 * ------------------------------------------------
 * Loads product data from a JSON resource file for the catalog service.
 */
@Repository
public class ProductJsonRepository implements IProductRepository {

    private static final String PRODUCTS_JSON_PATH = "data/products.json";

    private final ObjectMapper objectMapper;

    public ProductJsonRepository(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Product> findAll() {
        try {
            ClassPathResource resource = new ClassPathResource(PRODUCTS_JSON_PATH);

            try (InputStream inputStream = resource.getInputStream()) {
                return objectMapper.readValue(inputStream, new TypeReference<List<Product>>() {});
            }
        } catch (Exception exception) {
            throw new RuntimeException("Failed to load products from JSON resource", exception);
        }
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return findAll()
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }
}