package com.swk.xmlconfig.soundsystem;

/**
 * 一个CD实现
 */
public class CdDavid implements CompactDisc {

	private String title = "Smooth Criminal";
	private String artist = "David Garrett";
	
	public void play() {
		System.out.println(artist + "在演奏" + title);
	}

}
