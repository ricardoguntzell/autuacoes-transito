package br.com.guntz.transito.api.infra.doc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title("Autuações de Trânsito - API")
                        .description("Autuação de Trânsito é uma aplicação back-end " +
                                "inspirada através do curso Ignição Spring Rest da escola Algaworks.\n\n" +
                                "A aplicação consiste na exposição de uma API REST,\n" +
                                "que possibilita toda a gestão de autuações de trânsito.\n\n" +
                                "Os dados são coletados inicialmente pela própria API.")
                        .contact(new Contact()
                                .name("Guntz")
                                .email("rricardoguntzell@gmail.com"))
                        .license(new License()
                                .name("Guntz - Github")
                                .url("https://github.com/ricardoguntzell/autuacoes-transito")));
    }
}
