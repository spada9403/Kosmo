package com.osh.m5d26;

public class Person {
	String name;
	int age;
	public Person(){
		// this()생성자 호출은 항상 제일 앞에!
		this("이름없음",5);
	}
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
}
