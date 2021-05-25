package com.osh.m5d25_Class_Training;

public class Square {
	// 생성자
	public Square() {
		name = "45큐브";
		width = 45;
		height = 45;
	}
	public Square(String name) {
		this.name = name;
	}
	public Square(double w, double h) {
		width = w;
		height = h;
	}
	public Square(String name, double w, double h) {
		this.name = name;
		width = w;
		height = h;
	}
	
	
	// 멤버필드
	String name;
	double width;
	double height;
	
	
	// 멤버메서드
	public void printSquare() {
		System.out.println("name: " + name + " width: "+ width + " height: "+ height);
	}
	
}
