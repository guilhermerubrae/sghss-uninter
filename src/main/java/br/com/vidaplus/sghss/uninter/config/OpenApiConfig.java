package br.com.vidaplus.sghss.uninter.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * configuração simples do openapi / swagger
 * author: guilherme abreu
 * comentários em minúsculas
 */

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("sghss api").version("v1").description("documentação básica da api sghss"));
    }
}
