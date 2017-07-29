package com.snsoft.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class NewInstanceDemo2 {
	
	private static Properties p;
	private static String name = "obj.properties";
	
	/**
	 * 静态块加载资源文件
	 */
	static{
		p = new Properties();
		
		InputStream is = NewInstanceDemo2.class
				.getClassLoader().getResourceAsStream(name);
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取资源文件中的值
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		return p.getProperty(key);
	}
	
	/**
	 * 根据类名获得对象
	 * @param className
	 * @return
	 * @throws Exception
	 */
//	public static Object getBean(String className) throws  Exception{
//		Class<?> clazz = Class.forName(className);
////		return clazz.getConstructor(String.class).newInstance("mike...");
//		return clazz.newInstance();
//	}
	
	/**
	 * 使用泛型
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public static <T> T getBean(String className) throws Exception{
		@SuppressWarnings("unchecked")
		Class<T> cla = (Class<T>) Class.forName(className);
		return cla.newInstance();
	}
	
	/**
	 * 反射获取对象（泛型）
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static <T> T getBean(Class<T> clazz) throws Exception{
		return clazz.newInstance();
	}
	
	public static void main(String[] args) throws Exception {
//		String className = getValue("string");
//		Object obj = getBean(className);
//		String str = (String) obj;
//		System.out.println(str);
		
		String className = getValue("date");
		Object obj = getBean(className);
		Date date = (Date) obj;
		System.out.println(date.toString());
		
		System.out.println("-----------------使用泛型-----------------");
		date = getBean(className);
		System.out.println(date.toString());
		
		System.out.println("-----------------使用泛型-----------------");
		NewInstanceDemo2 nid = getBean(NewInstanceDemo2.class);
		System.out.println(nid);
	}

}
