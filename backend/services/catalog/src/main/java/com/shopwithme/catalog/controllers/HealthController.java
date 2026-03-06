package com.shopwithme.catalog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Copyright (c) 2026 OmegaEcommerce
 *
 * Class: HealthController
 *
 * Description:
 * ------------------------------------------------
 * Returns the status of the Controller.
 */

@RestController
public class HealthController {

    @GetMapping("/health")
    public Map<String, String> health(){
        return Map.of(
                "status", "ok",
                "service", "catalog"
        );
    }

}
