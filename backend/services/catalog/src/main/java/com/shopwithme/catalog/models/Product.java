package com.shopwithme.catalog.models;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Copyright (c) 2026 OmegaEcommerce
 * <p>
 * Class: Product
 * <p>
 * Description:
 * ------------------------------------------------
 * Represents a product in the catalog using a flat, extensible structure
 * that avoids hardcoding hierarchy such as category/subcategory fields.
 */

public class Product {
    private UUID id;
    private String sku;
    private String slug;

    private String name;
    private String brand;

    private String shortDescription;

    private String currency;
    private Double price;

    private Boolean inStock;
    private Boolean featured;
    private String status;

    private String thumbnailUrl;

    private List<String> categoryIds;
    private List<String> tags;

    private Map<String, String> attributes;

    public Product(
            UUID id,
            String sku,
            String slug,
            String name,
            String brand,
            String shortDescription,
            String currency,
            Double price,
            Boolean inStock,
            Boolean featured,
            String status,
            String thumbnailUrl,
            List<String> categoryIds,
            List<String> tags,
            Map<String, String> attributes
    ){
        this.id = id;
        this.sku = sku;
        this.slug = slug;
        this.name = name;
        this.brand = brand;
        this.shortDescription = shortDescription;
        this.currency = currency;
        this.price = price;
        this.inStock = inStock;
        this.featured = featured;
        this.status = status;
        this.thumbnailUrl = thumbnailUrl;
        this.categoryIds = categoryIds;
        this.tags = tags;
        this.attributes = attributes;
    }

    public UUID getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public String getStatus() {
        return status;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public List<String> getCategoryIds() {
        return categoryIds;
    }

    public List<String> getTags() {
        return tags;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setCategoryIds(List<String> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}