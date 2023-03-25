package com.prabhakar.circuitbreaker;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@SpringBootApplication
@RestController
@RequestMapping("/display/products")
public class SpringResilience4jProductOrderApplication {
	
	@Autowired
	RestTemplate restTemplate;
	
	private final String PRODUCT_ENDPOINT="http://localhost:8080/product/list";
	
	@GetMapping
	@CircuitBreaker(name = "productCircuit" ,fallbackMethod = "getDefaultProducts")
	public ResponseEntity<List<Product>> getProducts(){
		Product[] products = restTemplate.getForObject(PRODUCT_ENDPOINT, Product[].class);
		List<Product> list = Stream.of(products).toList();
		if(list != null) {
			return ResponseEntity.ok(list);
		}
		return ResponseEntity.ok(null);
	}
	
	public ResponseEntity<List<Product>> getDefaultProducts(Exception e){
		List<Product> list = Stream.of(
				new Product(1,"Iphone","Mobile"),
				new Product(2,"OnePlus","Mobile")
				).collect(Collectors.toList());
		
		if(list != null) {
			return ResponseEntity.ok(list);
		}
		return ResponseEntity.ok(null);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringResilience4jProductOrderApplication.class, args);
	}

}
