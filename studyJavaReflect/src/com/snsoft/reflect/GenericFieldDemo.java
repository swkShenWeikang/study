package com.snsoft.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class Student{
	
	private String name;
	private Map<String,Date> map = new HashMap<String,Date>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Date> getMap() {
		return map;
	}
	public void setMap(Map<String, Date> map) {
		this.map = map;
	} 
}

public class GenericFieldDemo {

	public static void main(String[] args) throws Exception {
		
		/**
		 *  Class<?> getType()  返回一个 Class 对象，它标识了此 Field 对象所表示字段的声明类型。 
		 */
		Class<Student> clazz = Student.class;
		Field field = clazz.getDeclaredField("name");
		Class<?> type = field.getType();
		System.out.println(type);//java.lang.String
		
		field = clazz.getDeclaredField("map");
		type = field.getType();
		System.out.println(type);//java.util.Map
		
		System.out.println("-------------------------");
		/**
		 *  Type getGenericType()   返回一个 Type 对象，它表示此 Field 对象所表示字段的声明类型。 
		 */
		Type genericType = field.getGenericType();
		System.out.println(genericType);//java.util.Map<java.lang.String, java.util.Date>
		
		/**
		 * 取到类型里面的泛型信息
		 */
		ParameterizedType pType = (ParameterizedType) genericType;
		
		/**
		 * Type getRawType() 返回 Type 对象，表示声明此类型的类或接口。 
		 */
		System.out.println(pType.getRawType());//java.util.Map
		System.out.println("-------------------------");
		
		/**
		 * Type[] getActualTypeArguments()  返回表示此类型实际类型参数的 Type 对象的数组。 
		 */
		Type[] types = pType.getActualTypeArguments();
		for (Type t : types) {
			System.out.println("-->" + t);
			
			Class<?> c = (Class<?>) t;
			String simpleName = c.getSimpleName();
			System.out.println(simpleName);
		}
		
	}//main

}//class
