package com.shopwithme.catalog.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * Copyright (c) 2026 shopwithme
 * <p>
 * Represents an e-commerce product with professional structure.
 * Aligns with schema.org Product and industry best practices.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

    private String id;
    private String sku;
    private String name;
    private String slug;
    private String description;
    private String shortDescription;
    private Brand brand;
    private Category category;
    private Pricing pricing;
    private List<ProductImage> images;
    private List<ProductVariant> variants;
    private Inventory inventory;
    private Map<String, String> attributes;
    private Seo seo;
    private ProductStatus status;
    private List<String> tags;
    private Instant createdAt;
    private Instant updatedAt;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }

    public List<ProductVariant> getVariants() {
        return variants;
    }

    public void setVariants(List<ProductVariant> variants) {
        this.variants = variants;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Seo getSeo() {
        return seo;
    }

    public void setSeo(Seo seo) {
        this.seo = seo;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public enum ProductStatus {
        DRAFT, ACTIVE, ARCHIVED, OUT_OF_STOCK
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Brand {
        private String id;
        private String name;

        public Brand() {
        }

        public Brand(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Category {
        private String id;
        private String name;
        private List<String> path;

        public Category() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getPath() {
            return path;
        }

        public void setPath(List<String> path) {
            this.path = path;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Pricing {
        private Double price;
        private Double compareAtPrice;
        private String currency;
        private Double costPerItem;

        public Pricing() {
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getCompareAtPrice() {
            return compareAtPrice;
        }

        public void setCompareAtPrice(Double compareAtPrice) {
            this.compareAtPrice = compareAtPrice;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public Double getCostPerItem() {
            return costPerItem;
        }

        public void setCostPerItem(Double costPerItem) {
            this.costPerItem = costPerItem;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ProductImage {
        private String url;
        private String alt;
        private Integer sortOrder;

        public ProductImage() {
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public Integer getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(Integer sortOrder) {
            this.sortOrder = sortOrder;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ProductVariant {
        private String id;
        private String sku;
        private Double price;
        private Map<String, String> attributes;
        private Inventory inventory;

        public ProductVariant() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Map<String, String> getAttributes() {
            return attributes;
        }

        public void setAttributes(Map<String, String> attributes) {
            this.attributes = attributes;
        }

        public Inventory getInventory() {
            return inventory;
        }

        public void setInventory(Inventory inventory) {
            this.inventory = inventory;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Inventory {
        private Boolean trackInventory;
        private Integer quantity;
        private Integer lowStockThreshold;
        private Boolean allowBackorder;

        public Inventory() {
        }

        public Boolean getTrackInventory() {
            return trackInventory;
        }

        public void setTrackInventory(Boolean trackInventory) {
            this.trackInventory = trackInventory;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getLowStockThreshold() {
            return lowStockThreshold;
        }

        public void setLowStockThreshold(Integer lowStockThreshold) {
            this.lowStockThreshold = lowStockThreshold;
        }

        public Boolean getAllowBackorder() {
            return allowBackorder;
        }

        public void setAllowBackorder(Boolean allowBackorder) {
            this.allowBackorder = allowBackorder;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Seo {
        private String title;
        private String description;

        public Seo() {
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
