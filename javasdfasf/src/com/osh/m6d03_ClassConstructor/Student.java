package com.osh.m6d03_ClassConstructor;

public class Student {
	
	int age;
	String name;
	
	
	// 생성자: 특별한 메서드.
	// 멤버 필드를 초기화 하는 역활을 한다.
	//Constructor 는 리턴 값이 없다.
	// Default Construcor 아무런 매개변수를 갖지 않는다.
	public Student() {
		this("홍길동", 0); // 생성자 메소드에서 this를 다른 생성자를 호출할때 사용할수 있다. 단, 맨 앞줄에 써야만 한다.
	}
	// Default Constructor가 기본으로 제공이 되지만,
	// Default Constructor를 생성하지 않고,
	// 다른 Construcor 만 생성한다면,(매개변수를 받는 생성자)
	// Defualt Constructor는 제공되지 않는다.

	
	public Student(String n, int a) {
		this.age = a; // this 는 클래스 안에서만 쓰이며, 자기 클래스가 인스턴스화 되었을때 자기자신의 클래스가 가지고 있는 변수를 지칭한다.
		this.name = n;
	}
}
