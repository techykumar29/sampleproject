package com.myapp.spring.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.spring.security.model.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, String>{

	UserEntity findByEmailId(String emailId);

}
