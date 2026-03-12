package com.shopwithme.catalog.exception;

/**
 * Copyright (c) 2026 shopwithme
 * <p>
 * Thrown when creating a product with an existing SKU.
 */
public class DuplicateSkuException extends RuntimeException {

    public DuplicateSkuException(String sku) {
        super("Product with SKU already exists: " + sku);
    }
}
