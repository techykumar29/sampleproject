package com.techykumar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product {

	private String id;
	private String title;
	private String price;
	private String description;
	private String category;
	private String image;
	
	
}
