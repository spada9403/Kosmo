package com.osh.m6d03_ClassConstructorExam;

public class Student1 {

	private String studentName;
	private int grade;
	private int money;
	
	public Student1() {
		this("",0);
	}
	public Student1(String name, int money) {
		this.money = money;
		this.studentName = name;
	}
	public void takeBus(Bus bus) {
		bus.take(1000);
		this.money -= 1000;
	}
	public void takeSubway(Subway subway) {
		subway.take(1000);
		this.money -= 1000;
	}
	public void showInfo() {
		System.out.println(studentName + "님의 남은 돈은" + money + "입니다.");
	}
}
