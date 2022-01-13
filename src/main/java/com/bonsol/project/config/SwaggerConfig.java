/**
 * @author angelabonsol
 */

package com.bonsol.project.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	 public Docket api() {
		 
		 return new Docket(DocumentationType.SWAGGER_2)
				 .apiInfo(apiDetails())
				 .select()
				 .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				 .paths(PathSelectors.any()) 
				 .build();
		 
	 }
	
	private ApiInfo apiDetails() {
		
		return new ApiInfo(
				"Nistle API", 
				"Music Listening Application", 
				"1.0", 
				"Free", 
				new Contact("Angela Bonsol", "N/A", "angelabonsol1@gmail.com"), 
				"API License",
				"N/A", 
				Collections.emptyList()
				);
	}

	
}
