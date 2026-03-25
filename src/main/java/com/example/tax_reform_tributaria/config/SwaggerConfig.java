package com.example.tax_reform_tributaria.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Simulador de Impacto Tributário (IBS/CBS)")
                .description("API para cálculo e simulação de impostos da Reforma Tributária (Modelo Atual vs CBS/IBS)."));
    }
}
