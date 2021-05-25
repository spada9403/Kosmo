package com.osh.m5d25_Class_Training;

public class Person {
	String name;
	int age;
	String gender;
	boolean married;
	int childs;

	public void print() {
		System.out.println("01. 나이: " + age);
		System.out.println("02. 이름: " + name);
		System.out.println("03. 결혼: " + married);
		System.out.println("04. 자녀: " + childs);
	}
}
