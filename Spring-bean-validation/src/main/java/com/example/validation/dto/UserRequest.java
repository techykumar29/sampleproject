package com.example.validation.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
	
	@NotBlank(message = "Name should not be null.")
	private String name;
	
	@Min(value = 18,message = "Age should be > 18.")
	@Max(value = 60,message = "Age should be <= 60.")
	private String age;
	
	@Email
	@NotNull
	private String email;
	
	@Pattern(regexp = "^\\d{10}$",message = "Phone number must be of 10 digits only.")
	private String phone;

}
