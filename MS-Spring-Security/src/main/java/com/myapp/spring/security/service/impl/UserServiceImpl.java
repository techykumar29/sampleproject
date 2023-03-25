package com.myapp.spring.security.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myapp.spring.security.dao.UserDao;
import com.myapp.spring.security.model.UserEntity;
import com.myapp.spring.security.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ModelMapper modelMapper;


	@Override
	public UserEntity createUser(UserEntity userEntity) {
		
		UserEntity savedUserEntity = userDao.save(userEntity);
		return savedUserEntity;
	}


	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		UserEntity userEntity = userDao.findByEmailId(emailId);
		if(userEntity == null) {
			throw new UsernameNotFoundException(emailId);
		}
		UserDetails userDetails = new User(emailId, userEntity.getEncryptedPassword(), true, true, true, true, new ArrayList<>());
		return userDetails;
	}

}
