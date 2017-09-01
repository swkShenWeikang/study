package com.swk.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.swk.annotation.concert.config.AopAnnotationConfig;
import com.swk.annotation.concert.pointcut.Performance;

public class AopAnnotationConfigMainTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AopAnnotationConfig.class);
		Performance per = context.getBean(Performance.class);
		per.perform();
	}

}
