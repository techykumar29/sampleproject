package com.prabhakar.springcloudstream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableBinding(Source.class)
@RestController
public class SpringCloudStreamApplication {

	@Autowired
	@Qualifier("output")
	private MessageChannel messageChannel;
	
	@PostMapping("/publish")
	public Book publishEvent (@RequestBody Book book) {
		 messageChannel.send(MessageBuilder.withPayload(book).build());
		 return book;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamApplication.class, args);
	}
	
	

}
