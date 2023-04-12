package com.example.catalog_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CatalogServiceApplication {

	@Bean
	public RestTemplate getrestTemplet(){
		return new RestTemplate();
	}
	@Bean
	public WebClient.Builder getWebClient(){
		return  WebClient.builder();

	}
	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}

}
