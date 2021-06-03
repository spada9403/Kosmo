package com.osh.m6d03_inheritance;

public class Airplane {
	
	public void fly() {
		System.out.println("아빌립 마 아캔플라이~");
	}
	public void land() {
		System.out.println("착륙합니다.");
	}
	public void takeOff() {
		System.out.println("이륙합니다");
	}
	

}
// IS-A 관게 비행이가능한 자동차는 비행기와 같다 등.
class carPlane extends Airplane{}

class carPlane2{
	// Has-A 관계 carPlane2는 Airplane 하나를 가지고 있다.
	Airplane plane = new Airplane();
}
