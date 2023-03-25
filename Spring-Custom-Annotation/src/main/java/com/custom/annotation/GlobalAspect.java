package com.custom.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GlobalAspect {
	Logger logger = LoggerFactory.getLogger(GlobalAspect.class);

	@Around("@annotation(com.custom.annotation.TrackExecution)")
	public Object totalTimeTaken(ProceedingJoinPoint pj) throws Throwable {
		logger.info("Inside Aspect:");
		Long start = System.currentTimeMillis();

		Object object = pj.proceed(pj.getArgs());
		Long end = System.currentTimeMillis();
		logger.info("Time taken in millisecond: "+ (end - start));
		return object;
	}
}
