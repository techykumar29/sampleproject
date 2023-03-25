package com.example.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.annotations.service.Vehicle;

@SpringBootApplication
public class SpringAnnotationsApplication implements CommandLineRunner {
	
	@Autowired
	ApplicationContext context;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringAnnotationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
