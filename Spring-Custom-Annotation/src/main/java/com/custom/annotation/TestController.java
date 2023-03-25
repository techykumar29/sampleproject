package com.custom.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	Test test;

	@GetMapping
	public ResponseEntity<String> test(){
		test.total(20000);
		
		return ResponseEntity.ok("Working fine");
	}
}
