package com.osh.m5d27;

import java.util.ArrayList;

public class Exam_279P_Q5 {
	
	public void draw() {
		System.out.println("Shape");
	}

	
	
	public static void main(String[] args) {
		ArrayList<Exam_279P_Q5> list = new ArrayList<Exam_279P_Q5>();
		list.add(new Circle());
		list.add(new Triangle());
		list.add(new Exam_279P_Q5());
		
		for(Exam_279P_Q5 s : list) {
			s.draw();
		}
	}
}
class Circle extends Exam_279P_Q5 {
	@Override
	public void draw() {
		System.out.println("Circle");
	}
}
class Triangle extends Exam_279P_Q5 {
	@Override
	public void draw() {
		System.out.println("Triangle");
	}
}
