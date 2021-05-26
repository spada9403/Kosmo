package com.osh.m5d26_Exam;

public class CalcuratorMain {

	public static void main(String[] args) {
		Calcurator calc = new Calcurator();
		
		calc.setOperand(10, 20);
		System.out.println(calc.avg());
		System.out.println(calc.sum());
		
		Sub_Calcurator scal = new Sub_Calcurator();
		
		scal.setOperand(20, 10);
		System.out.println(scal.sub());
		System.out.println(scal.sum());
		System.out.println(scal.avg());
		
	}

}
