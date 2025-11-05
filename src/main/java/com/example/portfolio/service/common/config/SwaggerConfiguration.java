package com.example.portfolio.service.common.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {



    @Bean
    public OpenAPI portfolioOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Portfolio Service API")
                        .description("API documentation for the portfolio service")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Orhan Türkmenoğlu")
                                .email("orhantrkmn749@gmail.com"))
                        .license(new License().name("Apache 2.0"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Portfolio Service Wiki Documentation")
                        .url("https://github.com/orhanturkmenoglu/portfolio-service"));
    }
}
