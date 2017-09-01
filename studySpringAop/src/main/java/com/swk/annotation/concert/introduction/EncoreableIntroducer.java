package com.swk.annotation.concert.introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 引入新功能接口的切面
 */
@Aspect
public class EncoreableIntroducer {
	
	@DeclareParents(value="com.swk.annotation.concert.pointcut.Performance+",
			defaultImpl=DefaultEncoreable.class)
	public static Encoreable encoreable;
}
