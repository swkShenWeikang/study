package com.swk.annotation.concert.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.swk.annotation.concert.aspect.Audience;
import com.swk.annotation.concert.introduction.EncoreableIntroducer;
import com.swk.annotation.concert.pointcut.Concert;

@Configuration
@EnableAspectJAutoProxy    //启用自动代理
public class AopAnnotationConfig {
	
	@Bean
	public Concert concert(){
		return new Concert();
	}
	
	@Bean
	public Audience audience(){
		return new Audience();
	}
	
	@Bean
	public EncoreableIntroducer encoreableIntroducer(){
		return new EncoreableIntroducer();
	}
}
