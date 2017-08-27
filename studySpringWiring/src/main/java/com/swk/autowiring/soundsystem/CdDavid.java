package com.swk.autowiring.soundsystem;

import org.springframework.stereotype.Component;

/**
 * 
 * @author 慎伟康
 * 
 * @date 2017年8月27日 下午6:25:11
 * 
 * @Description TODO
 *		一个CD实现
 */
@Component
public class CdDavid implements CompactDisc {

	private String title = "Viva La Vida";
	private String artist = "David Garrett";
	
	public void play() {
		System.out.println(artist + "在演奏" + title);
	}

}
