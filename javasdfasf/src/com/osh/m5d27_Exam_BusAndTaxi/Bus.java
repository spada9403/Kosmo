package com.osh.m5d27_Exam_BusAndTaxi;

public class Bus extends Vehicle{
	
	@Override
	public void run() {
		System.out.println("버스가 달린다.");
	}
	public void info() {
		System.out.println("버스가 노선을 달린다.");
	}
}
