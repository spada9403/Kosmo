package com.osh.m6d03_inheritance;

public class PhoneMain {

	public static void main(String[] args) {
		Phone phone1 = new Phone("전화", "레드", "111111");
		phone1.powerOn();
		phone1.ring();
		phone1.send();
		phone1.powerOff();
		
//		VideoPhone phone2 = new VideoPhone("영상전화", "노랑", "111112");
//		phone2.powerOn();
//		phone2.ring();
//		phone2.send();
//		phone2.videoCall();
//		phone2.powerOff();
		
		Phone phone3 = new VideoPhone(); // Auto Boxing(Up-Casting)
		
		// 기본적으로 phone3 은 Phone 자료형으로 선언ㄴ되어 Phone 클래스의 변수/ 메소드밖에 사용할수 없지만
		// VideoPhone 으로 다시 다운캐스팅 하여  VideoPhone 메소드를 사용 할수 있다.
		((VideoPhone)phone3).videoCall();// Down-Casting(Un-boxing)
		
		Phone phone4 = new Phone("전화", "붉은색", "111111");
		((VideoPhone)phone4).videoCall(); // -> 아무런 에러도 없는 것 같지만 실행하면, 런타임중에 ClassCastException 이라는 런타임 에러가 나온다.
		// phone3 은 사용하진 못하지만 일단 VideoCall()의 변수, 메서드의 인스턴스가 생성되어있다.
		// 하지만 phone4는 VideoCall()의 인스턴스가 생성되지 않았기 때문에 다운캐스팅을 할경우 에러가 나는것.
	}

}
