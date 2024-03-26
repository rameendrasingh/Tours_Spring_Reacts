package com.hughes;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply CORS configuration to all paths
            .allowedOrigins("*") // Allow requests from any origin
            .allowedMethods("*") // Allow all HTTP methods
            .allowedHeaders("*"); // Allow all headers
    }
}