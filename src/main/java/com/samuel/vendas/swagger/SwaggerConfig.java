package com.samuel.vendas.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI contaApi() {
        return new OpenAPI().info(new Info()
                .title("Controle de vendas API")
                .description("API de vendedores e vendas.")
                .version("1.0")
                .contact(new Contact()
                        .name("Samuel Modesto")
                        .url("https://www.linkedin.com/in/samuelmodesto/")
                        .email("samuelmodestoes@gmail.com"))
                .license(new License()
                        .name("Apache License Version 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}

