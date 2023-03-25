package com.prabhakar.insurance.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	Test test;
	
	
	@GetMapping
	public String test() {
		return test.getName();
	}

}
