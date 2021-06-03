package com.osh.m6d03_Reference;

public class VariableScopeEx {
	// 변수 /식별자 /객체
	// 멤버 변수 ==인스턴스변수 == 클래스변수
	int a= 0;
	int b = a;
	
	public static void main(String[] args) {
		
	}
	
	public void test() {
		this.a = 10;
	}
	//지역변수: 메서드 내부에서 선언된 변수.
	// 메서드의 매개변수
	public void local(String a, int b) {
		// 메서드 지역변수는 함수가 끝나면 소멸됨.
		// 매개변수로 참조값을 가져올경우 참조값이 가르키는 인스턴스가 변경됨.
		int c = 10;
		c = b + 100;
	}
}
