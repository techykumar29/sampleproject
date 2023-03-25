package com.example.validation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotBlank(message = "Name should not be null.")
	private String name;
	
	@Min(value = 18,message = "Age should be > 18.")
	@Max(value = 60,message = "Age should be <= 60.")
	private String age;
	
	@Email
	@NotNull
	private String email;
	
	@Pattern(regexp = "^\\d{10}$")
	private String phone;
	
	

}
