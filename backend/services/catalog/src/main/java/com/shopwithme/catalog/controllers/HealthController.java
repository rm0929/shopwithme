package com.shopwithme.catalog.controllers;

import com.shopwithme.catalog.models.HealthResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Copyright (c) 2026 shopwithme
 *
 * Class: HealthController
 *
 * Description:
 * ------------------------------------------------
 * Returns the status of the Controller.
 */

@RestController
public class HealthController {

    @GetMapping("/api/v1/health")
    public HealthResponse health(){
        return new HealthResponse("ok", "catalog");
    }

}
