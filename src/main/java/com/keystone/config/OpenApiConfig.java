package com.keystone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI keystoneOpenAPI() {

    	return new OpenAPI()
    	        .components(new Components()
    	                .addSecuritySchemes("Bearer Authentication",
    	                        new SecurityScheme()
    	                                .type(SecurityScheme.Type.HTTP)
    	                                .scheme("bearer")
    	                                .bearerFormat("JWT")))
    	        .addSecurityItem(
    	                new SecurityRequirement()
    	                        .addList("Bearer Authentication"))
    	        .info(new Info()
    	                .title("Keystone Field Service Management API")
    	                .version("1.0")
    	                .description("REST API for Keystone Field Service Management System")
    	                .contact(new Contact()
    	                        .name("Keystone Team")
    	                        .email("support@keystone.com")));
    }
}