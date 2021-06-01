package com.osh.m6d01_InnerClass;

import com.osh.m6d01_InnerClass.MyOutherClass.MyInnerClass;

public class MyOutherClassMain {

	public static void main(String[] args) {
		/*
		 * 내부 클래스의 객체를 생성하기 위해서는 반드시 외부 클래스의 객체가 필요.
		 * 외부 클래스 객체를 생성한 뒤 객체로부터 내부 클래스를 인스턴스화 해야 함.
		 */

		MyOutherClass obj = new MyOutherClass();
		
		MyInnerClass innerObj = obj.new MyInnerClass();
		// 위와같이 선언하여 사용하는걸 권장 하지는 않는다. 가능하면 외부 클래스 안에서만 쓰이도록,,
		// 내부 클래스는 임시적으로, 외부클래스가 잠시 사용하는 용도로 많이 사용.
		
	}

}
