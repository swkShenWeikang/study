package com.swk.annotation.concert.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 磁道播放计数器
 */
@Aspect
public class TrackCounter {
	
	private Map<Integer, Integer> trackCounts = new HashMap<Integer, Integer>();
	
	@Pointcut(
			"execution(* com.swk.annotation.concert.pointcut.BlankDisc.playTrack(int))" + 
			"&& args(trackNumber)")
	public void trackPlayed(int trackNumber){ }
	
	@Before("trackPlayed(trackNumber)")
	public void countTrack(int trackNumber){//前置通知，计数
		int currentCount = getPlayCount(trackNumber);
		trackCounts.put(trackNumber, currentCount + 1);
	}

	public int getPlayCount(int trackNumber) {
		return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
	}
}
