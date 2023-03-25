package com.example.validation.service;

import java.util.List;

import javax.validation.Valid;

import com.example.validation.dto.UserRequest;
import com.example.validation.entity.User;
import com.example.validation.exception.ResourceNotFoundException;


public interface UserService {
	
	User saveUser(UserRequest userRequest);
	
	User getUser(long id);
	
	List<User> getAllUser();

	int updatePhoneNumber(long id, String phone);

	User updateUser(long id, @Valid UserRequest userRequest) throws ResourceNotFoundException;


}
