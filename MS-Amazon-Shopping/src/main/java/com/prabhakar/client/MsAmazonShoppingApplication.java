package com.prabhakar.client;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MsAmazonShoppingApplication {
	
	@LoadBalanced
	@Bean
	 RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MsAmazonShoppingApplication.class, args);
	}

}
