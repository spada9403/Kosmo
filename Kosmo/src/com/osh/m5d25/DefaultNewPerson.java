package com.osh.m5d25;

public class DefaultNewPerson {
	String name;
	float height;
	float weight;

	// 특별한 메소드.(디폴트 생성자)
	// class 이름과 같다.
	// return 타입 X
	public DefaultNewPerson() {
		height = 0;
		weight = -1;

		System.out.println("Person 생성자" + "w: " + weight + "   h:" + height);
	}

	// 2 매개변수 생성자
	// 이렇게 생성자를 매개변수만 바꿔서 여러개 만드는것을 오버로딩이라고 한다.
	public DefaultNewPerson(String n) {
		name = n;
		System.out.println(name + ": " + "w: " + weight + "   h:" + height);
	}

	public DefaultNewPerson(String n, float w, float h) {
		name = n;
		height = h;
		weight = w;
		System.out.println(name + ": " + "w: " + weight + "   h:" + height);
	}
}
