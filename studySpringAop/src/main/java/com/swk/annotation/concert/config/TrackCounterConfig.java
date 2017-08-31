package com.swk.annotation.concert.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.swk.annotation.concert.aspect.TrackCounter;
import com.swk.annotation.concert.pointcut.BlankDisc;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {
	
	@Bean
	public BlankDisc blankDisc(){
		BlankDisc bd = new BlankDisc();
		bd.setArtist("The Beatles");
		bd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
		List<String> tracks = new ArrayList<String>();
		tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
		tracks.add("With a Little Help from My Friends");
		tracks.add("Lucy in the Sky with Diamonds");
		tracks.add("Getting Better");
		tracks.add("Fixing a Hole");
		tracks.add("She's Leaving Home");
		tracks.add("Being for the Benefit of Mr. Kite!");
		tracks.add("Within You Without You");
		bd.setTracks(tracks);
		return bd;
	}
	
	@Bean
	public TrackCounter trackCounter(){
		return new TrackCounter();
	}
}
