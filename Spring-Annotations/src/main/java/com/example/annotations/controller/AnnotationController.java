package com.example.annotations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.annotations.config.DownStreamProperties;

@RestController
@RequestMapping(value = "/annotations")
public class AnnotationController {
	
	@Value("${success.message}")
	String message;
	
	@Autowired
	Environment env;
	
	@Autowired
	DownStreamProperties downStreamProperties;

	@GetMapping("/properties")
	public ResponseEntity<DownStreamProperties> getCustomAnnotations(){
		return ResponseEntity.ok(downStreamProperties);
	}
	
	@GetMapping("/test")
	public String test() {
		return env.getProperty("database.name");
	}
}
