package com.kepf.ordervalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class OrderValidatorApplication {


	@Bean
	public WebClient.Builder getWebclientBuilder(){

		return WebClient.builder().defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
	}

	public static void main(String[] args) {

		SpringApplication.run(OrderValidatorApplication.class, args);

	}


}
