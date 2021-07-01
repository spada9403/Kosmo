package com.osh.m6d04_interface;

public class ClacMain {

	public static void main(String[] args) {
		calc c1 = new CompleteCalc();
		System.out.println(c1 instanceof calc);
		System.out.println(c1 instanceof CompleteCalc);
		System.out.println(c1 instanceof Calculater);
		c1 = new Calculater();
		System.out.println(c1 instanceof calc);
		System.out.println(c1 instanceof CompleteCalc);
		System.out.println(c1 instanceof Calculater);
		CompleteCalc c2 = new CompleteCalc();
		System.out.println(c2 instanceof calc);
		System.out.println(c2 instanceof CompleteCalc);
		System.out.println(c2 instanceof Calculater);
		Calculater c3 = new Calculater();
		System.out.println(c3 instanceof calc);
		System.out.println(c3 instanceof CompleteCalc);
		System.out.println(c3 instanceof Calculater);
		c3 = new CompleteCalc();
		System.out.println(c3 instanceof calc);
		System.out.println(c3 instanceof CompleteCalc);
		System.out.println(c3 instanceof Calculater);
	}

}
