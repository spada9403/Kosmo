package com.osh.m5d28_String_Exam;

public class StringBuilderTest {

	public static void main(String[] args) {

		String javaStr = new String("Java");
		System.out.println("javaStr 문자열 주소:" + System.identityHashCode(javaStr));
		
		StringBuilder buffer = new StringBuilder(javaStr);
		System.out.println("연산 전 Buffer 메모리 주소:" + System.identityHashCode(buffer));
		
		buffer.append(" and");
		buffer.append(" android");
		buffer.append( " programming is fun!!!");
		System.out.println("연산 후 Buffer 메모맂 주소:" + System.identityHashCode(buffer));
		
		javaStr = buffer.toString(); // toString() 으로 문자열로 바꿔줘야한다. buffer를 프린트하면 똑같이 나오긴 하나 정확히 String자료형이 아니기 때문에 컨버팅해줘야함.
		System.out.println(javaStr);
		System.out.println("연결된 javaStr 문자열 주소 : " + System.identityHashCode(javaStr));
		
	}

}
