package com.swk.xmlconfig;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.swk.xmlconfig.soundsystem.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="PropertyValueTest.xml")
public class PropertyValueTest {

	@Autowired
	private MediaPlayer player;
	
	@Test
	public void playerShouldNotBeNull(){
		assertNotNull(player);
		System.out.println("ok...");
	}

	@Test
	public void play() {
		player.play();
	}

}
