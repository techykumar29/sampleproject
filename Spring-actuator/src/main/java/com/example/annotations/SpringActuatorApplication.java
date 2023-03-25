package com.example.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringActuatorApplication implements CommandLineRunner {
	
	@Value("${myname}")
	String myName;

	public static void main(String[] args) {
		SpringApplication.run(SpringActuatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(myName);
		
	}

}
