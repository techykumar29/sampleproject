package com.example.webflux;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {
	
	@Test
	public void testMono() {
		
		Mono<?> publisher = Mono.just("javatechie")
				.then(Mono.error(()-> new RuntimeException("Exception thrown intentionally")))
				.log();
		publisher.subscribe(System.out::println,(e)-> System.out.println(e.getMessage()));
		
	}
	
	@Test
	public void testFlux() {
		Flux<?> publisher = Flux.just("Java","Java8","Spring","Spring MVC")
				.concatWithValues("AWS")
				.concatWith(Flux.error(new RuntimeException()))
				.log();
		publisher.subscribe(System.out::println);
	}

}
