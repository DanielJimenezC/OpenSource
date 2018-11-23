package com.TF.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	public static final Contact API_CONTACT = 
			new Contact("Open Source", "http://www.google.com", "correo@dominio.com");
	
	@SuppressWarnings("rawtypes")
	public static final ApiInfo API_INFO = 
			new ApiInfo("E-Nexus",
					"Proyecto de Trabajo Final", 
					"2.1", 
					"http://www.google.com", 
					API_CONTACT, 
					"Free", 
					"http://www.google.com", 
					new ArrayList<VendorExtension>());
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(API_INFO);
	}
	
}
