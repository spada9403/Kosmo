package com.osh.m5d27_Exam_Override;

public class ParentMain {

	public static void main(String[] args) {
		Parent parent = new Parent("홍길동");
		parent.info();
		
		Child child = new Child("홍홍",24);
		child.info();
	}

}
