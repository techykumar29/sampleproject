package com.example.annotations.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigurationProperties(prefix = "downstream.app")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DownStreamProperties {
	
	private String username;
	private String password;
	private String uri;

}
