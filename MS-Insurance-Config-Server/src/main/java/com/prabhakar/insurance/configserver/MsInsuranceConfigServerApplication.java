package com.prabhakar.insurance.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsInsuranceConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsInsuranceConfigServerApplication.class, args);
	}

}
