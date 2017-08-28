package com.swk.xmlconfig.collections;

import java.util.List;

import com.swk.xmlconfig.soundsystem.CompactDisc;

/**
 * 空白CD实现，加入磁道list集合。
 */
public class BlankDisc implements CompactDisc {

	private String title;
	private String artist;
	private List<String> tracks;

	public BlankDisc(String title, String artist, List<String> tracks) {
		this.title = title;
		this.artist = artist;
		this.tracks = tracks;
	}

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
		for (String track : tracks) {
			System.out.println("-Track: " + track);
		}
	}

}
