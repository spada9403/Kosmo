package com.osh.m5d26_Exam;

public class Ambulance extends Car{
	Ambulance() {
		this("구급차", 900);
	}
	Ambulance(String name, int dis) {
		setCarName(name);
		this.dis = dis;
	}
	protected void siren() {
		run();
		System.out.println("사이렌이 울립니다.");
	}
	protected void run() {
		System.out.println(getCarName() + "가 " + this.dis + "CC 배기량으로 사이렌을 울리며 달리고 있습니다.");
	}
}
