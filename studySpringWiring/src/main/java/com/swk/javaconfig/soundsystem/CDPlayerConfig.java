package com.swk.javaconfig.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Java配置文件
 */
@Configuration//表明这是一个配置类
public class CDPlayerConfig {
	
	@Bean
	public CompactDisc compactDisc(){
		return new CdDavid();
	}
	
	@Bean(name="player")
	public MediaPlayer mediaPlayer(CompactDisc compactDisc){
		return new CDPlayer(compactDisc);
	}
	
}
