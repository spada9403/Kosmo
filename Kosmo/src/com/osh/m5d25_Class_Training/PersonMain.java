package com.osh.m5d25_Class_Training;

public class PersonMain {

	public static void main(String[] args) {

		Person p1 = new Person();
		Person p2 = new Person();

		p1.name = "제임스";
		p1.age = 40;
		p1.childs = 3;
		p1.gender = "남자";

		p2.name = "홀라";
		p2.childs = 2;
		p2.gender = "여자";

		p1.print();
		p2.print();
	}

}
