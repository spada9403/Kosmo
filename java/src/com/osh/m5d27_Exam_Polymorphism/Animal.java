package com.osh.m5d27_Exam_Polymorphism;

public class Animal {
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
	public void moveAnimal(Animal animal) { // 매개변수의 자료형이 상위 클래스.(Animal) 모든 자식 클래스는 Animal 자료형으로 선언이 가능.
		animal.move(); // Animal 형으로 받은 모든 하위 클래스(자식클래스) 의 인스턴스 안에 재정의된 메소드를 실행.
	}
}
class Human extends Animal{
	@Override
	public void move() {
		System.out.println("사람이 두 발로 걷습니다.");
	}
}
class Tiger extends Animal{
	@Override
	public void move() {
		System.out.println("호랑이가 네 발로 뜁니다.");
	}
}
class Eagle extends Animal{
	@Override
	public void move() {
		System.out.println("독수리가 하늘을 납니다.");
	}
}

