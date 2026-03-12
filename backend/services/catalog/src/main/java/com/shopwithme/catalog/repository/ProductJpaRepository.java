package com.shopwithme.catalog.repository;

import com.shopwithme.catalog.entity.ProductEntity;
import com.shopwithme.catalog.models.Product;
import com.shopwithme.catalog.repository.interfaces.IProductRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * Copyright (c) 2026 shopwithme
 * <p>
 * Spring Data JPA repository for products.
 * Only active when postgres profile is enabled.
 */
@Repository
@Profile("postgres")
interface ProductJpaRepo extends JpaRepository<ProductEntity, String> {

    Optional<ProductEntity> findBySku(String sku);
    Optional<ProductEntity> findBySlug(String slug);
    List<ProductEntity> findByStatus(Product.ProductStatus status);

    @Query(value = "SELECT * FROM products WHERE category->>'id' = :categoryId", nativeQuery = true)
    List<ProductEntity> findByCategoryId(@Param("categoryId") String categoryId);
}

@Repository
@Profile("postgres")
public class ProductJpaRepository implements IProductRepository {

    private final ProductJpaRepo jpaRepo;

    public ProductJpaRepository(ProductJpaRepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public List<Product> findAll() {
        return StreamSupport.stream(jpaRepo.findAll().spliterator(), false)
                .map(ProductEntity::toProduct)
                .toList();
    }

    @Override
    public Optional<Product> findById(String id) {
        return jpaRepo.findById(id).map(ProductEntity::toProduct);
    }

    @Override
    public Optional<Product> findBySku(String sku) {
        return jpaRepo.findBySku(sku).map(ProductEntity::toProduct);
    }

    @Override
    public Optional<Product> findBySlug(String slug) {
        return jpaRepo.findBySlug(slug).map(ProductEntity::toProduct);
    }

    @Override
    public List<Product> findByCategory(String categoryId) {
        return jpaRepo.findByCategoryId(categoryId).stream()
                .map(ProductEntity::toProduct)
                .toList();
    }

    @Override
    public List<Product> findByStatus(Product.ProductStatus status) {
        return jpaRepo.findByStatus(status).stream()
                .map(ProductEntity::toProduct)
                .toList();
    }

    @Override
    public Product save(Product product) {
        if (product == null) return null;
        ProductEntity entity = ProductEntity.from(product);
        return jpaRepo.save(entity).toProduct();
    }

    @Override
    public void deleteById(String id) {
        jpaRepo.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return jpaRepo.existsById(id);
    }
}
