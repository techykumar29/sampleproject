package com.custom.annotation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.springframework.stereotype.Component;

@Component
public class Utility {

	@TrackExecution
	public Map<Integer,Integer> getSquares(int max) {
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < max; i++) {
			map.put(i, i*i);
		}
		return map;
		
	}
}
