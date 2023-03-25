package com.prabhakar.insurance.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:custom.properties")
public class Test {
	
	@Value("${myname}")
	private String name;

	public Test() {
		System.out.println("My Name is "+ name);
	}
	
	public String getName() {
		return name;
	}
}
