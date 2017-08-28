package com.swk.xmlconfig.properties;

import org.springframework.beans.factory.annotation.Autowired;

import com.swk.xmlconfig.soundsystem.CompactDisc;
import com.swk.xmlconfig.soundsystem.MediaPlayer;

/**
 * 播放器实现类，带字段setter方法
 */
public class CDPlayer implements MediaPlayer {
	
	private CompactDisc compactDisc;

	@Autowired
	public void setCompactDisc(CompactDisc compactDisc) {
		this.compactDisc = compactDisc;
	}

	public void play() {
		compactDisc.play();
	}

}
