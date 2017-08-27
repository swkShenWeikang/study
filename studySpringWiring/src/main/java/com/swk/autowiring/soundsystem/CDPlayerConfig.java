package com.swk.autowiring.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 启动自动扫描配置文件
 */
@Configuration
@ComponentScan(basePackageClasses=Marker.class)//@ComponentScan(basePackages="com.swk.autowiring.soundsystem")//启用了组件扫描
public class CDPlayerConfig {

}
