package com.shopwithme.catalog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Swagger UI at /swagger-ui.html, OpenAPI spec at /api-docs.
 */
@Configuration
public class OpenApiConfig {

    @Value("${server.port:8081}")
    private String port;

    @Bean
    public OpenAPI catalogOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Catalog API")
                        .description("Product catalog service for ShopWithMe e-commerce platform")
                        .version("1.0.0")
                        .contact(new Contact().name("ShopWithMe")))
                .servers(List.of(
                        new Server().url("http://localhost:" + port).description("Local"),
                        new Server().url("http://catalog:8081").description("Docker")
                ));
    }
}
