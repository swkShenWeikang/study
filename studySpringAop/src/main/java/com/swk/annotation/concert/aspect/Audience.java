package com.swk.annotation.concert.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 切面
 */
@Aspect    //声明为一个切面
public class Audience {
	
	//@Pointcut注解声明频繁使用的切点表达式
	@Pointcut("execution(* com.swk.annotation.concert.pointcut.Performance.perform(..))")
	public void performance(){
		//该方法本身只是一个标识，供@Pointcut注解依附。
	}
	
	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint jp){//环绕通知
		try {
			System.out.println("请就座！");
			System.out.println("请将手机静音！");
			jp.proceed();
			System.out.println("彩！彩！彩！");
		} catch (Throwable e) {
			System.out.println("退钱！");
		}
	}
	
//	@Before("execution(* com.swk.annotation.concert.pointcut.Performance.perform(..))")
//	public void silenceCellPhones(){//前置通知
//		System.out.println("请将手机静音！");
//	}
//	
//	@Before("performance()")
//	public void takeSeats(){//前置通知
//		System.out.println("请就座！");
//	}
//	
//	@AfterReturning("performance()")
//	public void applause(){//返回通知
//		System.out.println("彩！彩！彩！");
//	}
//	
//	@AfterThrowing("performance()")
//	public void demandRefund(){//异常通知
//		System.out.println("退钱！");
//	}
}
