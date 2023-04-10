package com.techykumar.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonPropertyOrder(value = {"id","title"})
@Component
public class Product {

	@JsonProperty("id")
	@NotNull
	private String id;
	private String title;
	private String description;
	private String price;
	private String discountPercentage;
	private String rating;
	private String stock;
	private String brand;
	private String category;
	private String thumbnail;
	private List<String> images;

}
