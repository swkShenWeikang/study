package com.swk.xmlconfig.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 一个CD播放器，需要一张CD
 */
public class CDPlayer implements MediaPlayer {
	
	private CompactDisc cd;
	
	@Autowired
	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}

	@Override
	public void play() {
		cd.play();
	}

}
