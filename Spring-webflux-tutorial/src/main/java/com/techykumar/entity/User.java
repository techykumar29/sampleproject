package com.techykumar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {

	private String id;
	private String email;
	private String username;
	private String password;
	private String phone;
}
