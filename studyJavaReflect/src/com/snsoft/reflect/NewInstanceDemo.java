package com.snsoft.reflect;

import java.lang.reflect.Constructor;


class Teacher{
	
//	public Teacher(){
//		
//	}
	
	private Teacher(String name){
		System.out.println(name);
	}
	
	public String toString() {
		return "老师";
	}
}


/**使用反射来创建对象
 * 	1.
 * 		public T newInstance(): 只能创建非private，无参的构造方法的对象；好比  new 类()；
 *  	T classInstance.newIntance();
 * 		如同用一个带有一个空参数列表的 new 表达式实例化该类。如果该类尚未初始化，则初始化这个类。 
 * 
 * 	2.
 * 		1>.先得到一个指定的构造方法，
 * 		2>.调用构造器里的一个方法，
 * 			T newInstance(Object... initargs) 
 * 			initargs表示构造器的需要的实际参数
 */
public class NewInstanceDemo {

	public static void main(String[] args) throws Exception {
		
//		Teacher t1 = new Teacher();
//		System.out.println("t1--" + t1);
		
		Class<Teacher> cla = Teacher.class;
//		Teacher t2 = cla.newInstance();
//		System.out.println("t2--" + t2);
//		System.out.println(t1 == t2);//false
		
		//调用有参的私有构造方法
		Constructor<Teacher> con = cla.getDeclaredConstructor(String.class);
		con.setAccessible(true);//设置私有为可访问的
		Teacher t3 = con.newInstance("mike");
		System.out.println("t3--" + t3);
		
	}

}
