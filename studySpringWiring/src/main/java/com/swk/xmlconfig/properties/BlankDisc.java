package com.swk.xmlconfig.properties;

import java.util.List;

import com.swk.xmlconfig.soundsystem.CompactDisc;

/**
 * 空白CD实现，添加字段setter方法。
 */
public class BlankDisc implements CompactDisc {

	private String title;
	private String artist;
	private List<String> tracks;

	public void setTitle(String title) {
		this.title = title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
		for (String track : tracks) {
			System.out.println("-Track: " + track);
		}
	}

}
