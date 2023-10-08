package com.techykumar.handler;

import java.net.URI;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.techykumar.entity.Product;
import com.techykumar.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ExternalApiHandler {

	@Autowired
	WebClient webclient;

	public Mono<ServerResponse> productHandler(ServerRequest request) {
		Flux<Product> productMono = webclient.get()
				.uri(URI.create("https://fakestoreapi.com/products"))
				.retrieve()
				.bodyToFlux(Product.class)
				.delayElements(Duration.ofMillis(1000))
				.log();
		return ServerResponse.ok().body(productMono, Product.class);
	}
	
	public Mono<ServerResponse> productHandlerById(ServerRequest request) {
		String productId = request.pathVariable("id");
		Mono<Product> productMono = webclient.get()
				.uri(URI.create("https://fakestoreapi.com/products/"+productId))
				.retrieve()
				.bodyToMono(Product.class)
				.delayElement(Duration.ofMillis(1000))
				.log();
		return ServerResponse.ok().body(productMono, Product.class);
	}
	
	public Flux<User> userHandler(ServerRequest request) {
		return webclient.get()
				.uri(URI.create("https://fakestoreapi.com/users"))
				.retrieve()
				.bodyToFlux(User.class)
				.delayElements(Duration.ofMillis(1000));
	}
}
