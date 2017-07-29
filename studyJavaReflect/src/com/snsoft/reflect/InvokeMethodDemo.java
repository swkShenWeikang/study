package com.snsoft.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

class Person{
	
	public void sayHello(){
		System.out.println("hello...");
	}
	
	public static String sayHello2(){
		return "Hello!!!";
	}
	
	@SuppressWarnings("unused")
	private String sayHello3(String name, int age){
		return name + age;
	}
	
	public String[] sayHello4(String name, int age){
		return new String[]{name, age + ""};
	}
	
	public String sayHello5(String name, int age){
		System.out.println(name + "-->" + age);
		return name + age;
	}
}

public class InvokeMethodDemo {
	
	public static void main(String[] args) throws Exception {
		
		/**
		 * 1.得到方法所在类的字节码; Class对象 
		 * 2.获取sayHello方法; Method对象
		 * 3.执行Method所表示的方法(sayHello);
		 */
		Class<Person> clazz = Person.class;
		Method m = clazz.getMethod("sayHello");
		m.invoke(clazz.newInstance());
		
		/**
		 * Object invoke(Object obj, Object... args) 
		 *     对带有指定参数的指定对象调用由此 Method对象表示的底层方法。
		 * 
		 * 参数： 
		 *     obj - 调用底层方法所属对象,这里的sayHello就是底层方法,obj就应该是sayHello所在类的一个对象; 
		 *     args - 底层方法调用需要的实际参数 返回： 访问底层方法的执行结果;
		 * 
		 * 如果底层方法是静态的，那么可以忽略指定的 obj 参数。该参数可以为 null。
		 * 
		 */
		m = clazz.getMethod("sayHello2");
		Object res = m.invoke(clazz.newInstance());
		System.out.println(res);
		System.out.println("-----------静态方法-----------");
		res = m.invoke(null);
		System.out.println(res);
		
		System.out.println("-----------私有方法-----------");
		m = clazz.getDeclaredMethod("sayHello3", String.class, int.class);
		m.setAccessible(true);//调用之前设置其为可访问的
		res = m.invoke(clazz.newInstance(), "mike", 15);
		System.out.println(res);
		
		/**
		 * 如果底层方法返回的是数组类型，invoke()方法返回的不是底层方法的值，而是底层方法的对象
		 */
		System.out.println("-----------返回数组-----------");
		m = clazz.getMethod("sayHello4", String.class, int.class);
		res = m.invoke(clazz.newInstance(), "mary", 22);
		System.out.println(res);
		String[] arr = (String[]) res;
		System.out.println(arr[0] + "年龄-->" + arr[1]);
		
		/**
		 * Array:
		 * 	static Object get(Object array, int index) 返回指定数组对象中索引的值。 
		 * 
		 *  static int getLength(Object array)    以 int 形式返回指定数组对象的长度。 
		 *  
		 *  static void set(Object array, int index, Object value)     
		 *  	将指定数组对象中索引组件的值设置为指定的新值。 
		 */
		System.out.println("-----------Array-----------");
		System.out.println(Array.getLength(arr));
		Array.set(arr, 0, "lucy");
		System.out.println(arr[0]);
		System.out.println(Array.get(arr, 0));
		for (int i = 0; i < Array.getLength(arr); i++) {
			System.out.println("array-->" + Array.get(arr, i));
		}
		
		System.out.println("-----------无参方法-----------");
		m = clazz.getMethod("sayHello");
//		m.invoke(clazz.newInstance());//true
//		m.invoke(clazz.newInstance(), null);//true    但有警告，不推荐
		m.invoke(clazz.newInstance(), new Object[]{});//true
		
		System.out.println("-----------参数数组-----------");
		m = clazz.getMethod("sayHello5", String.class, int.class);
		m.invoke(clazz.newInstance(), "mike", 18);//true
		m.invoke(clazz.newInstance(), new Object[]{"david", 19});//true    推荐
		//调用方法都习惯性地使用  new Object[]{实际参数};
		
	}//main

}//class
