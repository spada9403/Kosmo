package com.osh.m5d27_Exam_Override;

public class Computer extends Calcurator{

	
	@Override
	public double areaCircle(double r) {
		return Math.PI *r*r;
	}
}
