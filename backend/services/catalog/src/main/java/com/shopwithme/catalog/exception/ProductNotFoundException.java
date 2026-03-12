package com.shopwithme.catalog.exception;

/**
 * Copyright (c) 2026 shopwithme
 * <p>
 * Thrown when a product is not found.
 */
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String id, String type) {
        super("Product not found with " + type + ": " + id);
    }
}
