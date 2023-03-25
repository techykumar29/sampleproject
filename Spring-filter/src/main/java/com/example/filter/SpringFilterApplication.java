package com.example.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import com.example.filter.customProperties.MyDatabase;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
public class SpringFilterApplication implements CommandLineRunner {
	
	@Autowired
	ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(SpringFilterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		MyDatabase dbProperties = context.getBean(MyDatabase.class);
		System.out.printf("Username: %s, Name: %s, Password: %s", dbProperties.getUser(),dbProperties.getName(),dbProperties.getPassword());
		
	}

}
