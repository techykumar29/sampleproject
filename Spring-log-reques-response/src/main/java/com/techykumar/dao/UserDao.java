package com.techykumar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techykumar.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long>{

}
