package com.shopwithme.catalog.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Copyright (c) 2026 shopwithme
 * <p>
 * Request DTO for creating a product.
 */
public class CreateProductRequest {

    @NotBlank(message = "SKU is required")
    @Size(max = 128)
    private String sku;

    @NotBlank(message = "Name is required")
    @Size(max = 512)
    private String name;

    @Size(max = 512)
    private String slug;

    @Size(max = 4096)
    private String description;

    @Size(max = 512)
    private String shortDescription;

    @Valid
    private Product.Brand brand;

    @Valid
    private Product.Category category;

    @Valid
    private Product.Pricing pricing;

    private java.util.List<Product.ProductImage> images;

    private java.util.List<Product.ProductVariant> variants;

    @Valid
    private Product.Inventory inventory;

    private java.util.Map<String, String> attributes;

    @Valid
    private Product.Seo seo;

    private Product.ProductStatus status;

    private java.util.List<String> tags;

    public Product toProduct() {
        Product p = new Product();
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
        p.setStatus(status != null ? status : Product.ProductStatus.ACTIVE);
        p.setTags(tags);
        return p;
    }

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
    public java.util.List<Product.ProductImage> getImages() { return images; }
    public void setImages(java.util.List<Product.ProductImage> images) { this.images = images; }
    public java.util.List<Product.ProductVariant> getVariants() { return variants; }
    public void setVariants(java.util.List<Product.ProductVariant> variants) { this.variants = variants; }
    public Product.Inventory getInventory() { return inventory; }
    public void setInventory(Product.Inventory inventory) { this.inventory = inventory; }
    public java.util.Map<String, String> getAttributes() { return attributes; }
    public void setAttributes(java.util.Map<String, String> attributes) { this.attributes = attributes; }
    public Product.Seo getSeo() { return seo; }
    public void setSeo(Product.Seo seo) { this.seo = seo; }
    public Product.ProductStatus getStatus() { return status; }
    public void setStatus(Product.ProductStatus status) { this.status = status; }
    public java.util.List<String> getTags() { return tags; }
    public void setTags(java.util.List<String> tags) { this.tags = tags; }
}
