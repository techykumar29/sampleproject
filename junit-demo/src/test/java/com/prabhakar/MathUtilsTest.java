package com.prabhakar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

	MathUtils utils = null;
	
	@BeforeAll
    void beforAll() {
		System.out.println("Before All");
	}
	
	@BeforeEach
	void init() {
		utils = new MathUtils();
		System.out.println("Before Each");
	}
	
	@AfterEach
	void clear() {
		System.out.println("After each");
	}
	
	@Test
	void testAdd() {
		
		int actual = utils.add(2, 3);
		int expected = 5;
		assertEquals(expected, actual,"Should return the sum of two numbers");
	}
	
	@Test
	void testSquare() {
		
		int actual = utils.square(2);
		int expected = 4;
		assertEquals(expected, actual);
	}
	
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, ()-> utils.divide(2, 0));
	}

}
