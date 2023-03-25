package com.example.validation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.validation.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Modifying
	@Query("update User u set phone=:phone where id =:id")
	int updatePhoneNumber(long id,String phone);

}
