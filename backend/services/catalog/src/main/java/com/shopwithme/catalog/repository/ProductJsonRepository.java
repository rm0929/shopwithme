package com.shopwithme.catalog.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.shopwithme.catalog.models.Product;
import com.shopwithme.catalog.models.ProductCatalog;
import com.shopwithme.catalog.repository.interfaces.IProductRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * File-based repository using products.json. Active when profile=json.
 * Optional catalog.json.path allows external file for Docker volumes.
 */
@Repository
@Profile("json")
public class ProductJsonRepository implements IProductRepository {

    private static final Logger log = LoggerFactory.getLogger(ProductJsonRepository.class);

    private final ObjectMapper objectMapper;
    private final Resource dataResource;
    private final Path dataPath;
    private List<Product> products = new CopyOnWriteArrayList<>();

    public ProductJsonRepository(
            @Value("classpath:data/products.json") Resource dataResource,
            @Value("${catalog.json.path:}") String externalPath
    ) {
        this.dataResource = dataResource;
        this.objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        this.dataPath = (externalPath != null && !externalPath.isBlank())
                ? Path.of(externalPath) : null;
    }

    @PostConstruct
    public void loadProducts() throws IOException {
        try (InputStream is = dataResource.getInputStream()) {
            ProductCatalog catalog = objectMapper.readValue(is, ProductCatalog.class);
            if (catalog != null && catalog.getProducts() != null) {
                this.products = new CopyOnWriteArrayList<>(catalog.getProducts());
                log.info("Loaded {} products from JSON", products.size());
            }
        }
    }

    private void persist() {
        if (dataPath != null && Files.isWritable(dataPath)) {
            try (OutputStream os = Files.newOutputStream(dataPath)) {
                objectMapper.writerWithDefaultPrettyPrinter()
                        .writeValue(os, new ProductCatalog(List.copyOf(products)));
            } catch (IOException e) {
                log.warn("Could not persist to external path: {}", e.getMessage());
            }
        }
    }

    @Override
    public List<Product> findAll() {
        return List.copyOf(products);
    }

    @Override
    public Optional<Product> findById(String id) {
        return products.stream()
                .filter(p -> id != null && id.equals(p.getId()))
                .findFirst();
    }

    @Override
    public Optional<Product> findBySku(String sku) {
        return products.stream()
                .filter(p -> sku != null && sku.equals(p.getSku()))
                .findFirst();
    }

    @Override
    public Optional<Product> findBySlug(String slug) {
        return products.stream()
                .filter(p -> slug != null && slug.equals(p.getSlug()))
                .findFirst();
    }

    @Override
    public List<Product> findByCategory(String categoryId) {
        return products.stream()
                .filter(p -> p.getCategory() != null && categoryId != null
                        && categoryId.equals(p.getCategory().getId()))
                .toList();
    }

    @Override
    public List<Product> findByStatus(Product.ProductStatus status) {
        return products.stream()
                .filter(p -> status != null && status == p.getStatus())
                .toList();
    }

    @Override
    public Product save(Product product) {
        if (product == null) return null;
        var existing = findById(product.getId());
        if (existing.isPresent()) {
            products.removeIf(p -> product.getId().equals(p.getId()));
        }
        products.add(product);
        persist();
        return product;
    }

    @Override
    public void deleteById(String id) {
        products.removeIf(p -> id != null && id.equals(p.getId()));
        persist();
    }

    @Override
    public boolean existsById(String id) {
        return findById(id).isPresent();
    }
}
