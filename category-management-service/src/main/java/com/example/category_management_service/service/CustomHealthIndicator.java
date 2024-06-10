package com.example.category_management_service.service;

import java.net.URL;
import java.io.IOException;
import java.net.HttpURLConnection;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        boolean serviceUp = checkServiceHealth();
        if (serviceUp) {
            return Health.up().build(); 
        } else {
            return Health.down().build();
        }
    }

    private boolean checkServiceHealth() {
        try {
            URL url = new URL("http://localhost:8080/api/v1/categories");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            return responseCode == 200;
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Lỗi khi kiểm tra sức khỏe
        }
        
    }
}
