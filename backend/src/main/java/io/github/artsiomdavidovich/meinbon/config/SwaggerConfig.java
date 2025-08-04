package io.github.artsiomdavidovich.meinbon.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "MeinBon",
                description = " Web-application designed to automatize the process of gathering info and collecting statistics from e-receipts.",
                version = "1.0.0",
                contact = @Contact(
                        name = "Artsiom Davidovich",
                        email = "artiomdavidovich@gmail.com"
                )
        )
)
public class SwaggerConfig {

}
