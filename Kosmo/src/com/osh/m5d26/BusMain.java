package com.osh.m5d26;

public class BusMain {

	public static void main(String[] args) {
		
		// Bus 필드 name, number 접근을 위해
		// 1. 직접 사용가능하게 하거나 -> protected public default
		// 2. 메소드를 사용.. -> get set method
		
		Bus bus = new Bus("이름없음",30);
		
		System.out.println(bus.getName());
		System.out.println(bus.getNumber());
		
		bus.setName("홍길동");
		bus.setNumber(20);
		
		System.out.println(bus.getName());
		System.out.println(bus.getNumber());
	}

}
