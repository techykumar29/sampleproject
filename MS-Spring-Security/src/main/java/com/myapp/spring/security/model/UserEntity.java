package com.myapp.spring.security.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_TBL")
public class UserEntity {
	
	@Id
	private String emailId;
	
	private String userName;
	private String encryptedPassword;
	private String firstName;
	private String lastName;

}
