package com.shopwithme.catalog.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Copyright (c) 2026 shopwithme
 * <p>
 * Wrapper for products.json file structure.
 */
public class ProductCatalog {

    @JsonProperty("products")
    private List<Product> products;

    public ProductCatalog() {
    }

    public ProductCatalog(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
