package com.swk.annotation.concert.pointcut;

/**
 * 一场音乐会
 */
public class Concert implements Performance {

	@Override
	public void perform() {
		System.out.println("David Garrett在演奏Viva la vida!");
	}

}
