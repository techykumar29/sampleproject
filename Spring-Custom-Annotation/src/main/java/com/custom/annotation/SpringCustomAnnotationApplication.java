package com.custom.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCustomAnnotationApplication implements CommandLineRunner{
	
	@Autowired
	ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(SpringCustomAnnotationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Test test = context.getBean(Test.class);
		if(test != null) {
			//test.total(1000);
		}
		
	}

}
