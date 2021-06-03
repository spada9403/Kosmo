package com.osh.m6d03_ClassConstructorExam;

public class Subway {
	private int lineNumber;
	private int passengerCount;
	private int money;
	
	public Subway() {
		this(0);
	}
	public Subway(int busNumber) {
		this.lineNumber = busNumber;
	}
	public void take(int money) {
		this.money += money;
		passengerCount++;
	}
	public void showInfo() {
		System.out.println("버스 " + lineNumber + "의 승객은 " + passengerCount + "명이고 수입은 " + money + "입니다.");
	}
}
