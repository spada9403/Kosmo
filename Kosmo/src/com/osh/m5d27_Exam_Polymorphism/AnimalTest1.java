package com.osh.m5d27_Exam_Polymorphism;

public class AnimalTest1 {

	public static void main(String[] args) {
		Animal a = new Animal();
		a.moveAnimal(new Human()); // moveAnimal의 매개변수는 Animal(상위 클래스) 형. 하위클래스를 인스턴스로 생성가능.
		a.moveAnimal(new Tiger()); // moveAnimal이 매개변수로 받은 하위 클래스인스턴스의 재정의된 메소드를 실행.
		a.moveAnimal(new Eagle()); // 인스턴스를 매개변수로 ~
		
		/*
		 * 물론 Human h = new Human
		 * h.move(); 
		 * 이런것도 가능하다.
		 */
	}

}
