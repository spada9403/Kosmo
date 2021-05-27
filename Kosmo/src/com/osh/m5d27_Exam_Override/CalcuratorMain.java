package com.osh.m5d27_Exam_Override;

public class CalcuratorMain {

	public static void main(String[] args) {
		int r = 10;
		Calcurator calculator = new Calcurator();
		
		System.out.println("원면적: " + calculator.areaCircle(r));
		System.out.println();
		Computer computer = new Computer();
		System.out.println("원면적: " + computer.areaCircle(r));
	}

}
