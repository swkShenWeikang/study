package com.swk.javaconfig.soundsystem;

/**
 * 一个CD实现
 */
//@Component
public class CdDavid implements CompactDisc {

	private String title = "He's a Pirate";
	private String artist = "David Garrett";
	
	public void play() {
		System.out.println(artist + "在演奏" + title);
	}

}
