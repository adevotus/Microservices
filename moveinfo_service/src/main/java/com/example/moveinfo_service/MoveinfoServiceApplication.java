package com.example.moveinfo_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
//@EnableEurekaClient
public class MoveinfoServiceApplication {
@Bean
public RestTemplate restTemplate() {
	return new RestTemplate();
}
	public static void main(String[] args) {
		SpringApplication.run(MoveinfoServiceApplication.class, args);
	}

}
