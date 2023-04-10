package com.techykumar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techykumar.entity.LogReqRes;

public interface LoggingDao extends JpaRepository<LogReqRes, Long>{

}
