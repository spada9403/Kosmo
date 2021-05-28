package com.osh.m5d28_Equals_Exam;

public class String_Integer_Equals {

	public static void main(String[] args) {
		// String, Integer 클래스는 Equlas() 메소드가 재정의 되어있다.
		
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		System.out.println(str1 == str2); // 인스턴스 주소 값 비교
		System.out.println(str1.equals(str2));// String 클래스의 equals()메소드 사용. 두 인스턴스의 문자열 값이 같은지 비교.
		
		Integer int1 = new Integer(100); // 곧 사라질 메서드이다. 대체로 valueOf 메소드를 사용한다.
		Integer int2 = new Integer(100);
		
		System.out.println(int1 == int2); // 인스턴스 주소 값 비교
		System.out.println(int1.equals(int2)); // Integer 캘래스의 equals() 메소드 사용. 두 정수의 값이 같은지 비교함.
	}

}
