package com.shopwithme.catalog.services.interfaces;

import com.shopwithme.catalog.models.PageResponse;
import com.shopwithme.catalog.models.Product;

import java.util.List;
import java.util.Optional;

/**
 * Copyright (c) 2026 shopwithme
 * <p>
 * Service interface for product operations.
 */
public interface IProductService {

    List<Product> getAllProducts();

    PageResponse<Product> getProducts(int page, int size);

    Optional<Product> getProductById(String id);

    Optional<Product> getProductBySku(String sku);

    Optional<Product> getProductBySlug(String slug);

    List<Product> getProductsByCategory(String categoryId);

    List<Product> getProductsByStatus(Product.ProductStatus status);

    Product createProduct(Product product);

    Product createProductFromRequest(com.shopwithme.catalog.models.CreateProductRequest request);

    Product updateProduct(String id, Product product);

    void deleteProduct(String id);
}
