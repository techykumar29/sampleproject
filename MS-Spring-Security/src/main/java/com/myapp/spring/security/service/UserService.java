package com.myapp.spring.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.myapp.spring.security.model.UserEntity;

public interface UserService extends UserDetailsService{
	
	UserEntity createUser(UserEntity userEntity);

}
