package com.osh.m5d26_Exam;

public class Car {
	
	Car() {
		this("소나타", 300);
	}
	Car(String name, int dis){
		this.carName = name;
		this.dis = dis;
	}
	
	private String carName;
	protected int dis;
	
	protected void run()	{
		System.out.println(this.carName + "가 " + this.dis + "CC 배기량으로 달리고 있습니다.");
	}
	protected void setCarName(String n) {
		this.carName = n;
	}
	protected String getCarName() {
		return this.carName;
	}
	
}
