package com.techykumar.entity;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "LOG_REQ_RES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LogReqRes {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@Column(name = "ENDPOINT")
	private String uri;
	
	@Column(name = "HTTP_METHOD")
	private String httpMethod;
	
	@Column(name = "REQUEST")
	private String request;
	
	@Column(name = "RESPONSE")
	private String response;
	
	@CreationTimestamp
	@Column(name="TIMESTAMP_REQ_RES")
	private String createdon;

}
