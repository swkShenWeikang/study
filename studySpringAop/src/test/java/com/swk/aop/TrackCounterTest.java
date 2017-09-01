package com.swk.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.swk.annotation.concert.aspect.TrackCounter;
import com.swk.annotation.concert.config.TrackCounterConfig;
import com.swk.annotation.concert.pointcut.BlankDisc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TrackCounterConfig.class)
public class TrackCounterTest {
	
	@Autowired
	private BlankDisc cd;
	
	@Autowired
	private TrackCounter counter;
	
	@Test
	public void trackCounterTest(){
		cd.playTrack(1);
		cd.playTrack(3);
		cd.playTrack(1);
		cd.playTrack(2);
		cd.playTrack(2);
		cd.playTrack(1);
		cd.playTrack(2);
		cd.playTrack(5);
		cd.playTrack(6);
		cd.playTrack(8);
		cd.playTrack(2);
		cd.playTrack(3);
		for(int i = 0; i < 8; i++){
			System.out.println("磁道" + i + "播放数：" + counter.getPlayCount(i));
		}
	}
	
	@Test
	public void okTest(){
		System.out.println("ok...");
	}
}
