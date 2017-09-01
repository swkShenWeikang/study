package com.swk.annotation.concert.introduction;

/**
 * 引入新功能的接口实现类
 */
public class DefaultEncoreable implements Encoreable {

	@Override
	public void performEncore() {
		System.out.println("新功能。。。");
	}

}
