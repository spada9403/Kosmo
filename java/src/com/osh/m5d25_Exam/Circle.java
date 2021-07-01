package com.osh.m5d25_Exam;

public class Circle {

	// 생성자 메서드
	public Circle(String name, double radius) {
		this.name = name;
		this.radius = radius;
	}

	// 멤버 변수
	String name;
	double radius;

	// 멤버 메서드
	public void getArea() {
		System.out.println(name + "의 면적은 " + (3.14 * (radius * radius)));
	}
}
