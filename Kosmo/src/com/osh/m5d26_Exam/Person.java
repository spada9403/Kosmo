package com.osh.m5d26_Exam;

public class Person {
	String name;
	int age;
	String gender;
	String blood;
	String job;
	
	public Person() {
		this("이름없음",0);
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Person(String name, int age, String gender, String blood, String job) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.blood = blood;
		this.job = job;
	}
	
	public void play() {
		if(job == "의사") {
			System.out.println("진료한다");
		} else if(job == "골퍼") {
			System.out.println("라운딩 갔다.");
		} else if(job == "교수") {
			System.out.println("강의한다");
		} else {
			System.out.println("백수");
		}
	}
}
