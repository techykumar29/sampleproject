package com.myapp.spring.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private String emailId;

	private String userName;
	private String password;
	private String firstName;
	private String lastName;
}
