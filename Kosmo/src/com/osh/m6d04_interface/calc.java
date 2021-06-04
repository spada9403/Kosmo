package com.osh.m6d04_interface;

public interface calc {
	
	// 컴파일러가 상수로 취급한다.
	double PI = 3.14;
	int ERROR = -9999;
	
	// 컴파일러가 추상 메소드로 인식한다.
	int add(int n1, int n2);
	int substract(int n1, int n2);
	int times(int n1, int n2);
	int divide(int n1, int n2);
}
