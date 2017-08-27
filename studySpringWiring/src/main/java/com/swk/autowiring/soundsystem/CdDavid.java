package com.swk.autowiring.soundsystem;

import org.springframework.stereotype.Component;

/**
 * 一个CD实现
 */
@Component
public class CdDavid implements CompactDisc {

	private String title = "Viva La Vida";
	private String artist = "David Garrett";
	
	public void play() {
		System.out.println(artist + "在演奏" + title);
	}

}
