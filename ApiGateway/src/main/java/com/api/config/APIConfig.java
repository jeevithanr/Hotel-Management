package com.api.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
public class APIConfig {
    
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("guest-service", r -> r
                .path("/guest/**") 
                .uri("http://localhost:8087"))
            .route("rservation-service", r -> r
                .path("/reservations/**")
                .uri("http://localhost:8087"))
            .route("room-service", r -> r
                    .path("/rooms/**")
                    .uri("http://localhost:8087"))
            .route("discount-service", r -> r
                    .path("/discounts/**")
                    .uri("http://localhost:8087"))
            .build();
    }
}
