package com.techykumar.router;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.techykumar.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class UserRouter {

	List<User> list = new ArrayList<>();
	

	@Bean
	RouterFunction<ServerResponse> userRouterFunction() {
		return RouterFunctions.route()
				.GET("/api/welcome", request -> ServerResponse.ok()
						.body(Mono.just("Welcome to Reactive Programming using Spring Webflux."), String.class))
				.POST("/api/user/add", this::addUser)
				.GET("/api/users", this::getUsers)
				.build();
	}

	private Mono<ServerResponse> addUser(ServerRequest request) {
		Mono<User> userMono = request.bodyToMono(User.class);
		
		return userMono.flatMap(user -> {
			 list.add(user);
			 return ServerResponse.ok().bodyValue("User added successfully");
		});
	}

	private Mono<ServerResponse> getUsers(ServerRequest request) {
		Flux<User> users = Flux.fromIterable(list).delayElements(Duration.ofSeconds(2));
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(users, User.class);
	}

}
