package com.shopwithme.catalog.services;

import com.shopwithme.catalog.exception.DuplicateSkuException;
import com.shopwithme.catalog.exception.ProductNotFoundException;
import com.shopwithme.catalog.models.CreateProductRequest;
import com.shopwithme.catalog.models.PageResponse;
import com.shopwithme.catalog.models.Product;
import com.shopwithme.catalog.repository.interfaces.IProductRepository;
import com.shopwithme.catalog.services.interfaces.IProductService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Copyright (c) 2026 shopwithme
 * <p>
 * Default implementation of product service.
 */
@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public PageResponse<Product> getProducts(int page, int size) {
        List<Product> all = productRepository.findAll();
        long total = all.size();
        int from = Math.min(page * size, (int) total);
        int to = Math.min(from + size, (int) total);
        List<Product> pageContent = from < to ? all.subList(from, to) : List.of();
        return PageResponse.of(pageContent, page, size, total);
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> getProductBySku(String sku) {
        return productRepository.findBySku(sku);
    }

    @Override
    public Optional<Product> getProductBySlug(String slug) {
        return productRepository.findBySlug(slug);
    }

    @Override
    public List<Product> getProductsByCategory(String categoryId) {
        return productRepository.findByCategory(categoryId);
    }

    @Override
    public List<Product> getProductsByStatus(Product.ProductStatus status) {
        return productRepository.findByStatus(status);
    }

    @Override
    public Product createProduct(Product product) {
        if (product.getId() == null || product.getId().isBlank()) {
            product.setId("prod_" + UUID.randomUUID().toString().replace("-", "").substring(0, 12));
        }
        Instant now = Instant.now();
        product.setCreatedAt(now);
        product.setUpdatedAt(now);
        if (product.getStatus() == null) {
            product.setStatus(Product.ProductStatus.ACTIVE);
        }
        return productRepository.save(product);
    }

    @Override
    public Product createProductFromRequest(CreateProductRequest request) {
        if (productRepository.findBySku(request.getSku()).isPresent()) {
            throw new DuplicateSkuException(request.getSku());
        }
        return createProduct(request.toProduct());
    }

    @Override
    public Product updateProduct(String id, Product product) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id, "id"));
        product.setId(id);
        product.setCreatedAt(existing.getCreatedAt());
        product.setUpdatedAt(Instant.now());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id, "id");
        }
        productRepository.deleteById(id);
    }
}
