package com.osh.m5d28_String_Exam;

public class StringBuilderTest {

	public static void main(String[] args) {

		String javaStr = new String("Java");
		System.out.println("javaStr 문자열 주소:" + System.identityHashCode(javaStr));
		
		StringBuilder buffer = new StringBuilder(javaStr);
		System.out.println("연산 전 Buffer 메모리 주소:" + System.identityHashCode(buffer));
		//String 객체를 계속 만드는것은 메모리 낭비가 될수 있기 때문에,
		//버퍼를 사용한다.
		
		buffer.append(" and");
		buffer.append(" android");
		buffer.append( " programming is fun!!!");
		System.out.println("연산 후 Buffer 메모맂 주소:" + System.identityHashCode(buffer));
		
		javaStr = buffer.toString(); // toString() 으로 문자열로 바꿔줘야한다. buffer를 프린트하면 똑같이 나오긴 하나 toString()메서드를 사용하는것이기 때문에. String형으로 사용하려면 컨버팅이 필요.
		System.out.println(javaStr); // 자동으로 toString() 사용.
		System.out.println("연결된 javaStr 문자열 주소 : " + System.identityHashCode(javaStr));
		
	}

}
