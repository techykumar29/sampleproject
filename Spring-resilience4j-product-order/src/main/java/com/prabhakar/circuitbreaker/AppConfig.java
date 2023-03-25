package com.prabhakar.circuitbreaker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
