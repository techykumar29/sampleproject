package com.reactive.mongodb;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.reactive.mongodb.controller.ProductController;
import com.reactive.mongodb.dto.ProductDto;
import com.reactive.mongodb.service.ProductService;

import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@WebFluxTest(ProductController.class)
class SpringReactiveCrudMongoDbApplicationTests {

	
	@Autowired
	private WebTestClient webTestClient;
	
	@MockBean
	private ProductService service;
	
	@Test
	public void addProductTest() {
		Mono<ProductDto> productDto = Mono.just(new ProductDto("102","mobile",1,1000));
		when(service.saveProduct(productDto)).thenReturn(productDto);
		
		webTestClient.post().uri("/products").body(productDto,ProductDto.class).exchange().expectStatus().isOk();
	}
	
	@Test
	public void getProductsTest() {
		Flux<ProductDto> productDto = Flux.just(new ProductDto("102","mobile",1,1000),new ProductDto("103","tv",1,1000),new ProductDto("103","AC",1,1000));
		when(service.getProducts()).thenReturn(productDto);
		
		Flux<ProductDto> responseBody = webTestClient.get().uri("/products")
			.exchange()
			.expectStatus().isOk()
			.returnResult(ProductDto.class)
			.getResponseBody();
		
		StepVerifier.create(responseBody)
				.expectSubscription()
				.expectNext(new ProductDto("102","mobile",1,1000))
				.expectNext(new ProductDto("103","tv",1,1000))
				.expectNext(new ProductDto("103","AC",1,1000))
				.verifyComplete();
	}
	
	@Test
	public void getProductByIdTest() {
		Mono<ProductDto> productDto = Mono.just(new ProductDto("102","mobile",1,1000));
		when(service.getProduct(any())).thenReturn(productDto);
		
		Flux<ProductDto> responseBody = webTestClient.get().uri("/products/102")
			.exchange()
			.expectStatus().isOk()
			.returnResult(ProductDto.class)
			.getResponseBody();
		
		StepVerifier.create(responseBody)
			.expectSubscription()
			.expectNextMatches(p-> p.getName().equals("mobile"))
			.verifyComplete();
		
	}
	
	@Test
	public void updateProductTest() {
		Mono<ProductDto> productDto = Mono.just(new ProductDto("102","mobile",1,1000));
		when(service.updateProduct(productDto, "102")).thenReturn(productDto);
		
		webTestClient.put().uri("/products/update/102").exchange().expectStatus().isOk();
	}
	
	@Test
	public void deleteProductTest() {
		when(service.deleteProduct(any())).thenReturn(Mono.empty());
		
		webTestClient.delete().uri("/products/delete/102").exchange().expectStatus().isOk();
	}
	
}
