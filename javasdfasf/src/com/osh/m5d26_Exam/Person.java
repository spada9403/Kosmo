package com.osh.m5d26_Exam;

public class Person {
	String name;
	int age;
	String gender;
	String blood;
	String job;
	
	public Person() {
		this("이름없음",0); // => this(name,age,"","","직업없음");
	}
//	public Person(String name, int age) { 이렇게는 잘 사용하지 않는다.
//		this.name = name;
//		this.age = age;
//	}
	public Person(String name, int age) {// 보통 사용하는 패턴이 더 많은 멤버 변수를 초기화 하는 생성자를 호출한다.
		this(name,age,"","","직업없음");
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
			System.out.println("이름 : " + name + " 나이 : " + age + " 성별 : " + gender + " 혈액형 : " + blood + " 직업 : " + job);
			System.out.println("진료한다");
		} else if(job == "골퍼") {
			System.out.println("이름 : " + name + " 나이 : " + age + " 성별 : " + gender + " 혈액형 : " + blood + " 직업 : " + job);
			System.out.println("라운딩 갔다.");
		} else if(job == "교수") {
			System.out.println("이름 : " + name + " 나이 : " + age + " 성별 : " + gender + " 혈액형 : " + blood + " 직업 : " + job);
			System.out.println("강의한다");
		} else {
			System.out.println("이름 : " + name + " 나이 : " + age + " 성별 : " + gender + " 혈액형 : " + blood + " 직업 : " + job);
			System.out.println("백수");
		}
	}
}
