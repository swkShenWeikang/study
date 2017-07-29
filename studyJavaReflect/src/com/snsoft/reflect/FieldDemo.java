package com.snsoft.reflect;

import java.lang.reflect.Field;
import java.util.Date;

class Emp {

	private String name;
	private int age;
	private Date hireDate;

	public String toString() {
		return "Emp [name=" + name + ", age=" + age + ", hireDate=" + hireDate + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
}//class

public class FieldDemo {

	public static void main(String[] args) throws Exception {
		
		/**
		 * 使用反射来操作字段: name
		 */
		Class<Emp> clazz = Emp.class;
		Field fieldName = clazz.getDeclaredField("name");
//		System.out.println(fieldName);
		
		/**
		 * void set(Object obj, Object value)   
		 * 		将指定对象变量上此 Field 对象表示的字段设置为指定的新值。 
		 * 参数：
		 *		obj - 应该修改其字段的对象
		 *		value - 正被修改的 obj 的字段的新值 
		 */
		Emp emp = clazz.newInstance();
		fieldName.setAccessible(true);
		fieldName.set(emp, "david");
		System.out.println(emp);
		
		System.out.println("--------------------------");
		Field fieldAge = clazz.getDeclaredField("age");
		fieldAge.setAccessible(true);
		fieldAge.setInt(emp, 18);
		System.out.println(emp);
		
		/**
		 * public Object get(Object obj)
		 *	获得字段对象的值;
		 *	参数: obj - 表示字段所属的对象
		 */
		System.out.println("--------------------------");
		Object name = fieldName.get(emp);
		System.out.println(name);
		
		int age = fieldAge.getInt(emp);
		System.out.println(age);
		
	}//main

}//class
