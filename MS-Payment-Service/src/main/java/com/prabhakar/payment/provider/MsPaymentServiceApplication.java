package com.prabhakar.payment.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPaymentServiceApplication.class, args);
	}

}
