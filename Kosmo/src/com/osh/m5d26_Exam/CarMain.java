package com.osh.m5d26_Exam;

public class CarMain {

	public static void main(String[] args) {
		Car car = new Car("제네시스",800);
		car.run();
		Ambulance am = new Ambulance();
		am.run();
	}

}
