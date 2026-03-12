package com.shopwithme.catalog.entity;

import com.shopwithme.catalog.models.Product;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * Copyright (c) 2026 shopwithme
 * <p>
 * JPA entity for product storage in PostgreSQL.
 */
@Entity
@Table(name = "products", indexes = {
        @Index(name = "idx_product_sku", columnList = "sku", unique = true),
        @Index(name = "idx_product_slug", columnList = "slug", unique = true),
        @Index(name = "idx_product_status", columnList = "status")
})
public class ProductEntity {

    @Id
    @Column(length = 64)
    private String id;

    @Column(nullable = false, unique = true, length = 128)
    private String sku;

    @Column(nullable = false, length = 512)
    private String name;

    @Column(unique = true, length = 512)
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 512)
    private String shortDescription;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Product.Brand brand;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Product.Category category;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Product.Pricing pricing;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<Product.ProductImage> images;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<Product.ProductVariant> variants;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Product.Inventory inventory;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, String> attributes;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Product.Seo seo;

    @Enumerated(EnumType.STRING)
    @Column(length = 32)
    private Product.ProductStatus status;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<String> tags;

    private Instant createdAt;
    private Instant updatedAt;

    public static ProductEntity from(Product p) {
        if (p == null) return null;
        ProductEntity e = new ProductEntity();
        e.setId(p.getId());
        e.setSku(p.getSku());
        e.setName(p.getName());
        e.setSlug(p.getSlug());
        e.setDescription(p.getDescription());
        e.setShortDescription(p.getShortDescription());
        e.setBrand(p.getBrand());
        e.setCategory(p.getCategory());
        e.setPricing(p.getPricing());
        e.setImages(p.getImages());
        e.setVariants(p.getVariants());
        e.setInventory(p.getInventory());
        e.setAttributes(p.getAttributes());
        e.setSeo(p.getSeo());
        e.setStatus(p.getStatus());
        e.setTags(p.getTags());
        e.setCreatedAt(p.getCreatedAt());
        e.setUpdatedAt(p.getUpdatedAt());
        return e;
    }

    public Product toProduct() {
        Product p = new Product();
        p.setId(id);
        p.setSku(sku);
        p.setName(name);
        p.setSlug(slug);
        p.setDescription(description);
        p.setShortDescription(shortDescription);
        p.setBrand(brand);
        p.setCategory(category);
        p.setPricing(pricing);
        p.setImages(images);
        p.setVariants(variants);
        p.setInventory(inventory);
        p.setAttributes(attributes);
        p.setSeo(seo);
        p.setStatus(status);
        p.setTags(tags);
        p.setCreatedAt(createdAt);
        p.setUpdatedAt(updatedAt);
        return p;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }
    public Product.Brand getBrand() { return brand; }
    public void setBrand(Product.Brand brand) { this.brand = brand; }
    public Product.Category getCategory() { return category; }
    public void setCategory(Product.Category category) { this.category = category; }
    public Product.Pricing getPricing() { return pricing; }
    public void setPricing(Product.Pricing pricing) { this.pricing = pricing; }
    public List<Product.ProductImage> getImages() { return images; }
    public void setImages(List<Product.ProductImage> images) { this.images = images; }
    public List<Product.ProductVariant> getVariants() { return variants; }
    public void setVariants(List<Product.ProductVariant> variants) { this.variants = variants; }
    public Product.Inventory getInventory() { return inventory; }
    public void setInventory(Product.Inventory inventory) { this.inventory = inventory; }
    public Map<String, String> getAttributes() { return attributes; }
    public void setAttributes(Map<String, String> attributes) { this.attributes = attributes; }
    public Product.Seo getSeo() { return seo; }
    public void setSeo(Product.Seo seo) { this.seo = seo; }
    public Product.ProductStatus getStatus() { return status; }
    public void setStatus(Product.ProductStatus status) { this.status = status; }
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
