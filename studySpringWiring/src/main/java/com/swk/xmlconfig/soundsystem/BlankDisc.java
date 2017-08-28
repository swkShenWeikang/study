package com.swk.xmlconfig.soundsystem;

/**
 * 空白CD实现
 */
public class BlankDisc implements CompactDisc {
	
	private String title;
	private String artist;
	
	public BlankDisc(String title, String artist) {
	    this.title = title;
	    this.artist = artist;
	}
	
	@Override
	public void play() {
		System.out.println(artist + "在演奏" + title);
	}

}
