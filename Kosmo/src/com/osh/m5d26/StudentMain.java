package com.osh.m5d26;

public class StudentMain {

	public static void main(String[] args) {
		Student lee = new Student();
		// lee.studentName = "홍길동"; 직접적으로 변수에 접근이 가능하게 하면 보안성이 매우 떨어진다.
		lee.setStudentName("홍길동");
		// 메서드를 통해 간접적으로 접근이 가능하게 한다.
	}

}
