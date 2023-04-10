package com.techykumar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techykumar.dao.UserDao;
import com.techykumar.dto.UserDtoReq;
import com.techykumar.dto.UserDtoRes;
import com.techykumar.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	ModelMapper objMapper;

	@Override
	public UserDtoRes addUser(UserDtoReq userDtoReq) {
		UserEntity userEntity = objMapper.map(userDtoReq, UserEntity.class);
		UserEntity userEntitySaved = userDao.save(userEntity);
		UserDtoRes userDtoRes = objMapper.map(userEntitySaved, UserDtoRes.class);
		return userDtoRes;
	}

	@Override
	public void updateUser(UserDtoReq userDtoReq,long id) throws Exception {
		
		Consumer<UserEntity> consumer = (user)-> {
			user.setFirstName(userDtoReq.getFirstName());
			user.setLastName(userDtoReq.getLastName());
			user.setMobile(userDtoReq.getMobile());
			user.setNationality(userDtoReq.getNationality());
			userDao.save(user);
		};
		Optional<UserEntity> userEntity = userDao.findById(id);
		if(userEntity.isPresent()) {
			userEntity.ifPresent(consumer);
		}else {
			throw new Exception("User not found");
		}
		
	}

	@Override
	public List<UserDtoRes> getAllUsers() {
		List<UserEntity> userEntityList = userDao.findAll();
		List<UserDtoRes> userDtoResList = new ArrayList<>();
		for(UserEntity userEntity: userEntityList) {
			userDtoResList.add(objMapper.map(userEntity, UserDtoRes.class));
		}
		return userDtoResList;
	}

}
