package com.osh.m6d01_InnerClass;
// 정적 InnerClass
public class StaticInnerClass {

	static class MyInnerClass {
		final static public int age = 0; // 원래는 static 사용 불가능. InnerClassExam2 참조
	}
	public static void main(String[] args) {
		MyInnerClass innerObj = new StaticInnerClass.MyInnerClass();
		// Inner 클래스를 static으로 선언하면 외부 클래스를 인스턴스화하지 않고도 내부 클래스를 직접적으로 인스턴스화 할수 있다.
		// 정적 Inner Class 안에서는 static을 사용할수있다.
	}
	
}
