package com.osh.day4;

public class var_Char {
	public static void main(String[] args) {
		/*
		 * char 형 : char형은 자바가 .unicode를 기반에두기 때문에 2 Byte를 쓴다. 1바이트를 쓰면 아스키 코드와 호환되고,
		 * 그외에 문자들은 유니코드와 호환된다. 아스키 코드는 영문 대소문자, 특수문자, 숫자를 표기할수있다. 유니코드는 아스키 코드를 포함해 한글,
		 * 한자 등등을 표기할수있다. 문자를 변수에 저장하면 그 문자에 해당하는 정수값(아스키 코드, 유니코드 등) 이 저장된다.
		 */
		// char형 연습 문자형(아스키코드/유니코드) Not 문자열
		char char1 = 'A'; // 2Byte == int
		System.out.println(char1);
		System.out.println("A문자의 정수값은 = " + (int) char1); // Casting 서로비슷한 범위고 타입이면 데이터타입 변경이 가능하다!!

		char char2 = 66; // 아스키코드 / 유니코드 를 직접 쓸수 있다!
		System.out.println("66을 char형으로 하면 : " + char2);
		char ch = '\uD55C'; // (16진수)D55C = 한 = 54620(10진수), \(유니코드의 escape sequence 형식)u + 16진수 > 유니코드
							// 표현방식.
		System.out.println(ch);

		int char3 = 67;
		System.out.println("C의 정수값 : " + char3);
		System.out.println("67을 char형으로 하면 : " + (char) char3);

		// 음수는 표현 불가능.

		int a = 65;
		int b = -66;

		System.out.println((char) a);
		System.out.println((char) b); // 원래는 ?문자가 나와야 한다.
	}
}
