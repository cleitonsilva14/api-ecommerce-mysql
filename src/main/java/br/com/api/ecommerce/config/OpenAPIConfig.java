package br.com.api.ecommerce.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;


@OpenAPIDefinition(
	info = @Info(
		title = "Ecommerce API",
		description = "Complete API for ecommerce",
		summary = "Uma API completa para gerenciar e-commerce",
		termsOfService = "https://app.swaggerhub.com/eula",
		license = @License(
			name = "GPL 3.0",
			url = "https://opensource.org/license/gpl-3-0"
		),
		contact = @Contact (
			name = "SpringBoot developer",
			email = "localhost@gmail.com",
			url = "https://springdoc.org/"
		)
	)	
)
public class OpenAPIConfig {

}
