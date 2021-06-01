package com.osh.m6d01_InnerClass;

public class InnerClassExam2 {
	static class InnerClass {
		static String keyword = "STATIC INNER";
		
		public void info() {
			System.out.println("Inner.info()");
		}
		public static void printName() {
			System.out.println("Inner.printName()");
		}
	}

	public static void main(String[] args) {

		InnerClass inner = new InnerClassExam2.InnerClass(); // 외부 클래스 인스턴스를 만들지 않았다!!
		System.out.println(InnerClass.keyword); // static이기 때문에 바로 접근이 가능하다.
		
		inner.info();
		InnerClass.printName(); // 메소드도 똑같이 가능.
		
	}

}
