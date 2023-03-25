package com.example.filter.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@Value("${server.name}")
	private String server;
	List<String> products = new ArrayList<>();
	
	@GetMapping("/products")
	public List<String> products(){
		
		
		products.add("Macbook Pro");
		products.add("Hp Noteboot Elite");
		products.add("Lenovo Thinkpad");
		return products;
	}
	
	@GetMapping("/books")
	public List<String> books(){
		
		List<String> products = new ArrayList<>();
		products.add("Mini Habits");
		products.add("The Alchemist");
		products.add("The Final Interview");
		return products;
	}
	
	@PostMapping("/product/add")
	public List<String> addProduct(@RequestBody Product product){
		products.add(product.getName());
		return products;
	}
	

}
