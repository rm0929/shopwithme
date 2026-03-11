package com.shopwithme.catalog.services.interfaces;


import com.shopwithme.catalog.models.Product;

import java.util.List;

/**
 * Copyright (c) 2026 OmegaEcommerce
 * <p>
 * Class: IProductService
 * <p>
 * Description:
 * ------------------------------------------------
 * Defines product-related operations for the catalog service.
 */

public interface IProductService {
    List<Product> getAllProducts();
}
