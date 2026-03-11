package com.shopwithme.catalog.repository.interfaces;

import com.shopwithme.catalog.models.Product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Copyright (c) 2026 OmegaEcommerce
 * <p>
 * Class: IProductRepository
 * <p>
 * Description:
 * ------------------------------------------------
 * Defines product data access operations for the catalog service.
 */

public interface IProductRepository {
    List<Product> findAll();
    Optional<Product> findById(UUID id);
}
