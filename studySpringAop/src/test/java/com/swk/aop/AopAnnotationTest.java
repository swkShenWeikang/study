package com.swk.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.swk.annotation.concert.aspect.Audience;
import com.swk.annotation.concert.config.AopAnnotationConfig;
import com.swk.annotation.concert.pointcut.Performance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AopAnnotationConfig.class)
public class AopAnnotationTest {
	
	@Autowired
	private Performance performance;
	
	@Autowired
	private Audience audience;
	
	@Test
	public void play(){
		performance.perform();
	}
	
	@Test
	public void okTest(){
		System.out.println("ok...");
	}
}
