package com.prabhakar.circuitbreaker;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/product/list")
public class SpringResilience4jProductCatalogApplication {

	List<Product> list = new ArrayList<>();

	@PostConstruct
	void initProductList() {
		list.add(new Product(1, "Mac Pro ", "Laptop"));
		list.add(new Product(2, "The Final Interview", "Book"));
		list.add(new Product(3, "Cat", "Animal"));
		list.add(new Product(4, "HP Notebook ", "Laptop"));
		list.add(new Product(5, "Watch ", "Accessory"));
		list.add(new Product(6, "The Alchemist ", "Book"));
		list.add(new Product(7, "Linux Kali ", "Laptop"));
		list.add(new Product(8, "Acer Notebook ", "Laptop"));
	}

	@GetMapping
	ResponseEntity<List<Product>> getProducts() {
		return ResponseEntity.ok(list);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringResilience4jProductCatalogApplication.class, args);
	}

}
