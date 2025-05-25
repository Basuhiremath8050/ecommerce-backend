package com.ecommerce.product_service.config; // or com.ecommerce.userservice.config

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("E-Commerce Microservice API")
                .version("1.0")
                .description("API documentation for E-Commerce microservices"));
    }
}
