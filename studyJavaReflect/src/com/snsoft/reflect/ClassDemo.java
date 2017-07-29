package com.snsoft.reflect;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


enum Gender{
	MAN,WOMAN(),NONE{};
}

class User{

}


/**
 *	得到Class对象的三种方式：
 *
 *	1. 通过类的class属性；
 *		类.class;
 *
 * 	2. 使用Class.forName(String className);  className表示 一个类的全限定名
 *		
 *			Class clz = Class.forName("java.util.Date");
 *			此时 clz 就在描述 java.util.Date这个类
 *
 *	3. 通过对象的一个 getClass()方法可以搞定
 *		Class<?> getClass()    返回此 Object 的运行时类。 
 *
 */
public class ClassDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//1. 通过类的class属性；
		Class<User> clazz1 = User.class;
		Class<User> clazz2 = com.snsoft.reflect.User.class;
		System.out.println(clazz1 == clazz2);
		
		//2. 使用Class.forName(String className);
		String className = "java.util.Date";
		Class<?> cla = Class.forName(className);
		@SuppressWarnings("unchecked")
		Class<Date> claDate = (Class<Date>) cla;
		System.out.println(cla);
		System.out.println(claDate);
		
		System.out.println(clazz1 == Class.forName("com.snsoft.reflect.User"));
		
		
		//3. 通过对象的一个 getClass()方法可以搞定
		List<?> l = new ArrayList<>();
		Class<?> claList = l.getClass();
		System.out.println(claList);		//java.util.ArrayList
		System.out.println(l.getClass());	//java.util.ArrayList
		
		
		System.out.println("Gender.MAN = " + Gender.MAN.getClass());//com.snsoft.reflect.Gender
		System.out.println("Gender.WOMAN = " + Gender.WOMAN.getClass());//com.snsoft.reflect.Gender
		System.out.println("Gender.NONE = " + Gender.NONE.getClass());//com.snsoft.reflect.Gender$1
		
	}

}
