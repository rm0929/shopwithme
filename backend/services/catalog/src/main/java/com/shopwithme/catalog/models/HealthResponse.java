package com.shopwithme.catalog.models;


/**
 * Copyright (c) 2026 shopwithme
 * <p>
 * Class: HealthResponse
 * <p>
 * Description:
 * ------------------------------------------------
 * Represents the health status response for the catalog service
 */

public class HealthResponse {
    private String status;
    private String service;

    public HealthResponse(String status, String service) {
        this.status = status;
        this.service = service;
    }

    public String getStatus(){
        return status;
    }

    public String getService(){
        return service;
    }
}