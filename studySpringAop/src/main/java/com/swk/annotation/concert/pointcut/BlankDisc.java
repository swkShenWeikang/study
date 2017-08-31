package com.swk.annotation.concert.pointcut;

import java.util.List;

/**
 * 空白CD实现，添加字段setter方法。
 */
public class BlankDisc {

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

	/**
	 * 播放一个磁道的歌曲
	 * @param trackNumber
	 */
	public void playTrack(int trackNumber){
		if(trackNumber < tracks.size()){
			System.out.println("播放" + tracks.get(trackNumber));
		}else{
			System.out.println("播放出错了！");
		}
	}
	
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
		for (String track : tracks) {
			System.out.println("-Track: " + track);
		}
	}

}
