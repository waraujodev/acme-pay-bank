package br.com.acmepay.acmepayloadbalancer.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("customer_service", r -> r.path("/customers")
                        .and()
                        .method("POST")
                        .uri("lb://customer-service"))
                .build();
    }
}
