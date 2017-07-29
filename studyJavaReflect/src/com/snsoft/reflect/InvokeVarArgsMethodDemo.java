package com.snsoft.reflect;

import java.lang.reflect.Method;
import java.util.Arrays;


class OOXX{
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
	}
	
	public static void show1(String ... args){
		System.out.println(Arrays.toString(args));
	}
	
	public static void show2(int[] args){
		System.out.println(Arrays.toString(args));
	}
}

/**
 * 要把可变参数都当做是其对应的数组类型参数;
 * 如 show(XX... is)作为show(XX[] is)调用;
 * 
 * 若可变参数元素类型是引用类型:
 *     JDK内部接收到参数之后,会自动拆包取出参数再分配给该底层方法,
 *     为此我们需要把这个数组实参先包装成一个Object对象或者把实际参数作为一个Object一维数组的元素再传递。
 * 
 * 若可变参数元素类型是基本类型:
 *     JDK内部接收到参数之后,不会拆包,所以可以不必再封装.不过封装了也不会错.
 *     所以建议,不管基本类型还是引用类型都使用Object[]封装一层,保证无误.
 *
 *
 * 以后使用反射调用方法:
 *		推荐使用 invoke(方法底层对象, new Object[]{ 底层方法需要的实际参数  });
 */
public class InvokeVarArgsMethodDemo {

	public static void main(String[] args) throws Exception {
		
		Class<OOXX> clazz = OOXX.class;
		Method m = clazz.getMethod("show1", String[].class);
//		System.out.println(m);
		
//		m.invoke(null, "Will","17");//false    当做是  show1(String s1,String s2){}有歧义
//		m.invoke(null, new String[]{"Will","17"});//false
//		m.invoke(null, new Object[]{"Will","17"});//false
//		m.invoke(null, (Object)new String[]{"Will","17"});//true
		m.invoke(null, new Object[]{new String[]{"Will","17"}});//true, 推荐
		//调用方法都习惯性地使用  new Object[]{实际参数};
		
		System.out.println("-----------分割线-----------");
		m = clazz.getMethod("show2", int[].class);
//		m.invoke(null, 1,2,3);//false
//		m.invoke(null, new int[]{1,2,3});//true -->基本数据类型不拆包
//		m.invoke(null, new Object[]{1,2,3});//false
//		m.invoke(null, (Object)new int[]{1,2,3});//true
		m.invoke(null, new Object[]{new int[]{1,2,3}});//true
		
		System.out.println("-----------主方法-----------");
		//调用OOXX的主方法:
		m = clazz.getMethod("main", String[].class);
		m.invoke(null, new Object[]{new String[]{"凤姐","春哥"}});
		
	}//main

}
