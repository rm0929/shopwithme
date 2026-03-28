package com.shopwithme.cart.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI cartServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cart Service API")
                        .description("Cart microservice for ShopWithMe e-commerce application")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("ShopWithMe")
                                .email("dev@shopwithme.com")));
    }
}