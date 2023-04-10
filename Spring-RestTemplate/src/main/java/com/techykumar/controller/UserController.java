package com.techykumar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techykumar.model.Product;
import com.techykumar.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(name = "UserController", path = "/user")
public class UserController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}
	
	@PostMapping("/products")
	ResponseEntity<String> getAllProducts(@RequestBody Product product){
		productService.getAllProducts().add(product);
		return ResponseEntity.ok("Product added successfully.");
	}

}
