package com.shopwithme.catalog.repository.interfaces;

import com.shopwithme.catalog.models.Product;

import java.util.List;
import java.util.Optional;

/**
 * Repository contract for product persistence. Swap implementations via Spring profiles
 * (json vs postgres) without changing service layer.
 */
public interface IProductRepository {

    List<Product> findAll();

    Optional<Product> findById(String id);

    Optional<Product> findBySku(String sku);

    Optional<Product> findBySlug(String slug);

    List<Product> findByCategory(String categoryId);

    List<Product> findByStatus(Product.ProductStatus status);

    Product save(Product product);

    void deleteById(String id);

    boolean existsById(String id);
}
