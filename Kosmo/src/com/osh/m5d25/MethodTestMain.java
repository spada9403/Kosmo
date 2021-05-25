package com.osh.m5d25;

public class MethodTestMain {

	public static void main(String[] args) {
		
		MethodClass m = new MethodClass();
		
		int r = m.add(10, 100);
		
		m.add(10, 100); // return 값을 안 받을수도 있다.
		
		m.getTenTotal();
		
		m.printTenTotal();
		
		m.printGreeting("hahaha");
		
		m.divide(100, 1);
		
		m.divide(100, 0);
		
	}

}
