package com.techykumar.service;

import java.util.List;

import com.techykumar.dto.UserDtoReq;
import com.techykumar.dto.UserDtoRes;

public interface UserService {

	UserDtoRes addUser(UserDtoReq userDtoReq);
	void updateUser(UserDtoReq userDtoReq, long id) throws Exception;
	List<UserDtoRes> getAllUsers();
		
	
}
