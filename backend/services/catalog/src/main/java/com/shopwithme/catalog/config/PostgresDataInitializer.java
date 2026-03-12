package com.shopwithme.catalog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.shopwithme.catalog.models.Product;
import com.shopwithme.catalog.models.ProductCatalog;
import com.shopwithme.catalog.repository.interfaces.IProductRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * One-time seed from products.json when using postgres profile.
 * Skips if products already exist.
 */
@Component
@Profile("postgres")
public class PostgresDataInitializer {

    private static final Logger log = LoggerFactory.getLogger(PostgresDataInitializer.class);

    private final IProductRepository repository;
    private final Resource productsResource;

    public PostgresDataInitializer(
            IProductRepository repository,
            @Value("classpath:data/products.json") Resource productsResource
    ) {
        this.repository = repository;
        this.productsResource = productsResource;
    }

    @PostConstruct
    public void init() {
        if (repository.findAll().isEmpty()) {
            try (InputStream is = productsResource.getInputStream()) {
                ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
                ProductCatalog catalog = mapper.readValue(is, ProductCatalog.class);
                if (catalog != null && catalog.getProducts() != null) {
                    for (Product p : catalog.getProducts()) {
                        repository.save(p);
                    }
                    log.info("Seeded {} products from products.json", catalog.getProducts().size());
                }
            } catch (Exception e) {
                log.warn("Could not seed products from JSON: {}", e.getMessage());
            }
        }
    }
}
