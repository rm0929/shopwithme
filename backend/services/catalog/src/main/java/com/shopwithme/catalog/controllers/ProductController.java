package com.shopwithme.catalog.controllers;

import com.shopwithme.catalog.exception.ProductNotFoundException;
import com.shopwithme.catalog.models.CreateProductRequest;
import com.shopwithme.catalog.models.PageResponse;
import com.shopwithme.catalog.models.Product;
import com.shopwithme.catalog.services.interfaces.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright (c) 2026 shopwithme
 * <p>
 * REST API for product catalog operations.
 */
@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Products", description = "Product catalog operations")
public class ProductController {

    private static final int DEFAULT_PAGE_SIZE = 20;
    private static final int MAX_PAGE_SIZE = 100;

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Operation(summary = "List products", description = "Get all products with optional pagination")
    public ResponseEntity<?> getProducts(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size
    ) {
        if (page != null && size != null) {
            int p = Math.max(0, page);
            int s = Math.min(MAX_PAGE_SIZE, Math.max(1, size));
            return ResponseEntity.ok(productService.getProducts(p, s));
        }
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(productService.getProductById(id)
                .orElseThrow(() -> new ProductNotFoundException(id, "id")));
    }

    @GetMapping("/sku/{sku}")
    @Operation(summary = "Get product by SKU")
    public ResponseEntity<Product> getProductBySku(@PathVariable String sku) {
        return ResponseEntity.ok(productService.getProductBySku(sku)
                .orElseThrow(() -> new ProductNotFoundException(sku, "sku")));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get product by slug")
    public ResponseEntity<Product> getProductBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(productService.getProductBySlug(slug)
                .orElseThrow(() -> new ProductNotFoundException(slug, "slug")));
    }

    @GetMapping(params = "category")
    @Operation(summary = "Get products by category")
    public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam String category) {
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @GetMapping(params = "status")
    @Operation(summary = "Get products by status")
    public ResponseEntity<List<Product>> getProductsByStatus(@RequestParam Product.ProductStatus status) {
        return ResponseEntity.ok(productService.getProductsByStatus(status));
    }

    @PostMapping
    @Operation(summary = "Create product")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody CreateProductRequest request) {
        Product created = productService.createProductFromRequest(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update product")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        Product updated = productService.updateProduct(id, product);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
