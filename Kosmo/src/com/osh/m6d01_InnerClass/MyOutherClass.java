package com.osh.m6d01_InnerClass;

// 하나의 자바 파일로 다수의 클래스를 사용할 수 있기 때문에 코드 관리 편리.
// inner class의 선언부의 형태와 사용법에 따른 네 가지 종류.
// 인스턴스 내부 클래스. : 클래스 in 클래스
// 정적 내부 클래스 : Static을 붙인 내부 클래스.
// 지역 내부 클래스 : 메소드 내부에 클래스를 선언한 경우. 메소드의 안에서만 유효
// 익명 내부 클래스 : 이미 만들어진 클래스를 필요한 메소드만 재정의해서 사용하는것.

public class MyOutherClass { // 외부 클래스의 이름을 파일이름으로 저장.
	
	class MyInnerClass{
		// Inner Class 사용하는 이유 : 코드의 간략화.
		/*
		 * 내부 클래스의 메소드나 속성에static 속성은 사용할수 없다.
		 * final 사용이 가능하다.
		 * 내부 클래스를 사용하기 위해서는 외부 클래스 인스턴스화가 필요.
		 * 내부 클래스의 클래스 이름은 외부 클래스 안에서만 중복되지 않으면 된다.
		 */
		static final int age = 0;
		String name;
		
		final public void test() {
			// static 사용 불가능 final 가능
		}
	}
	
	public void test() {
	}
	
}
