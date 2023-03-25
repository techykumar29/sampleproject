package com.custom.annotation;

import java.util.stream.LongStream;

import org.springframework.stereotype.Component;

@Component
public class Test {

	@TrackExecution
	public long total(long count) {
		LongStream.rangeClosed(0, count).forEach(p -> {
			System.out.print(p);
		});
		return 0;
	}
}
