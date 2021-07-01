package com.osh.m5d27_Exam_BusAndTaxi;

public class Taxi extends Vehicle {
	
	
	@Override
	public void run() {
		System.out.println("택시가 달린다.");
	}
	public void info() {
		System.out.println("택시에 승객이 탑승.");
	}
	
}
