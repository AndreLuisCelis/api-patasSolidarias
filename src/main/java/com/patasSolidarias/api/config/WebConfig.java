package com.patasSolidarias.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/auth/**") // Mapeia todos os endpoints que começam com /auth/
        		.allowedOriginPatterns("*") // Permite a origem do seu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*")
                .allowCredentials(true); // Permite cookies
        registry.addMapping("/api/**") // Mapeia todos os endpoints que começam com /api/
        		.allowedOriginPatterns("*")
        		.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
        		.allowedHeaders("*")
        		.allowCredentials(true);
        registry.addMapping("/file/**") // Mapeia todos os endpoints que começam com /api/
				.allowedOriginPatterns("*")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
				.allowedHeaders("*")
				.allowCredentials(true);
    }
}