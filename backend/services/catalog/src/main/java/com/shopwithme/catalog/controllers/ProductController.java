package com.shopwithme.catalog.controllers;


import com.shopwithme.catalog.models.Product;
import com.shopwithme.catalog.services.interfaces.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Copyright (c) 2026 OmegaEcommerce
 * <p>
 * Class: ProductController
 * <p>
 * Description:
 * ------------------------------------------------
 * Handles product-related HTTP endpoints.
 */
@RestController
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService){
        this.productService = productService;
    }

    @GetMapping("/api/v1/products")
    public List<Product> getProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/api/v1/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id){
        return productService.getProductById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}