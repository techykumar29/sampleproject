package com.prabhakar.springcloudstream;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringCloudStreamConsumerApplication {
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	@StreamListener("input")
	public void consumeMessage(Book book) {
		logger.info("Consume payload:"+book);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamConsumerApplication.class, args);
	}

}
