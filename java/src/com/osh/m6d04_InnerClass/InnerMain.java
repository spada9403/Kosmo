package com.osh.m6d04_InnerClass;

import com.osh.m6d04_InnerClass.InnerClassTest.InnerClass;

public class InnerMain {

	public static void main(String[] args) {
		// 인스턴스 내부 클래스 객체화.
		InnerClassTest outer = new InnerClassTest();
		InnerClass inner = outer.new InnerClass();
		
		// 정적 내부 클래스 객체화
		InnerClassTest.StaticInnerClass sclass = new InnerClassTest.StaticInnerClass();
		
		int j = InnerClassTest.StaticInnerClass.i;
	}

}
