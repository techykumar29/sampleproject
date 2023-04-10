package com.techykumar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDtoRes {
	
	private long id;
	private String firstName;
	private String lastName;
	private String mobile;
	private String nationality;

}
