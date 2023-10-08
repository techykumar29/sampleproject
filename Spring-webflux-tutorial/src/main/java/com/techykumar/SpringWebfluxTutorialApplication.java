package com.techykumar;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SpringWebfluxTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxTutorialApplication.class, args);
		test();
	}
	
	private static void test() {
		Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // Publisher

        flux
            .doOnNext(item -> {
                if (item == 5) {
                    throw new RuntimeException("Error after processing item 3");
                }
            })
            .flatMap(item -> {
                return Flux.just(item * 2);
            })
            .subscribe(
                value -> System.out.println("Processed Value: " + value),
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Completed")
            );
	}

}
