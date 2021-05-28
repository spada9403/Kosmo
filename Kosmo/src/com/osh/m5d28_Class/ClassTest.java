package com.osh.m5d28_Class;

import java.lang.reflect.Method;

import com.osh.m5d28_Equals_Exam.EqualsTest;

public class ClassTest {

	public static void main(String[] args) {

		//1 Object 클래스의 getClass() 메서드 사용하기
		String s= new String();
		Class c = s.getClass();
		// getClass() 메서드의 반환형은 Class
		Method[] m = c.getMethods();
		for(Method method:m) {
			System.out.println(method.getName());
		}
		//2 클래스 파일 이름을 Class 변수에 직접 대입하기
		c = String.class;
		c = EqualsTest.class;
		//3 
		try {
			c = Class.forName("com.osh.m5d28_Clone_Exam.ObjectCloneTest");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(c.getName());
	}

}
