package com.ss.openapi3.sample.main;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	public Docket getDetailsApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ss.openapi3")).paths(regex("/.*")).build().apiInfo(metaData());

	}

	private ApiInfo metaData() {

		ApiInfo apiInfo = new ApiInfo(
				"Funds Caching Microservice",
				"Apigee Internal Demo",
				"1.0",
				"Terms of service",
				new Contact("Venkata/Karthik/Nitesh", "https://mysite.statestr.com", "nnigam@statestreet.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;

	}

}