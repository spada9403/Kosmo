package com.osh.m5d27_Interface;

public interface Calc {

	double PI = 3.13;
	int ERROR = -99999; // 인터페이스에서 선언한 변수는 컴파일 과정에서 상수로 변환됨.
	
	
	int add(int num1, int nim2); // 인터페이스에서 선언한 메서드는 컴파일 과정에서 추상 메서드로 변환됨.
	int substract(int num1, int num2); // 반환형 이름( 매개변수 ) ; 작성.
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
}
