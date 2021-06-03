package com.osh.m6d03_inheritance;

public class VideoPhone extends Phone {
	public VideoPhone(String m, String c, String n) {
		super(m,c,n);// 상위 클래스의 Phone의 생성자를 호출한다.
		//super(); 사용이 불가능하다. 상위클래스에 default 생성자가 없기 때문이다.상위클래스에 기본생성자가 있으면 사용이 가능하다.
		// 상위클래스에 아무런 생성자가 정의되지 않았을 경우에는 컴파일러가 자동으로 기본생성자를 호출하기때문에 super() 메소드를 안써도 된다.
		// 자식클래스는 부모 클래스의 멤버변수와 메서드도 사용해야하기 떄문에 반드시 부모클래스의 생성자를 호출해야만 한다.
		// 만약 상위 클래스에 정의한 생성자가 있다면 그 생성자를 super()를 통해 호출 해줘야 한다.
		// 이처럼 super는 자식클래스가 부모클래스의 멤버 변수나 메소드를 사용할때 쓴다.
	}
	public void videoCall() {System.out.println("영상통화");}
	public void info() {
		String a = super.model;
	}
}
