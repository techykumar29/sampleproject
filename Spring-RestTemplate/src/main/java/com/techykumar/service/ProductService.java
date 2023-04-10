package com.techykumar.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.techykumar.model.Product;
import com.techykumar.model.ProductList;

@Service
public class ProductService {
	
	@Autowired
	RestTemplate restTemplate;

	public List<Product> getAllProducts(){
		String uri = "https://dummyjson.com/products";
		ResponseEntity<ProductList> response = restTemplate.exchange(uri, HttpMethod.GET, null, ProductList.class);
		return response.getBody().getProducts();
	}
}
