package com.osh.m6d03_ClassConstructor;

public class ConstructorExam {
	public static void main(String[] args) {
		Student student1 = new Student();
		student1.name = "홍길동";
		student1.age = 10;
		
		Student student2 = new Student();
		student1.name = "고길동";
		student1.age = 15;
		
		Student student3 = new Student();
		student1.name = "도우너";
		student1.age = 14;
		
		Student student4 = new Student("이순신",15);
		
	}
}
