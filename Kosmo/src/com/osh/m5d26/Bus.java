package com.osh.m5d26;

public class Bus {
	private String name;
	private int number;
	public Bus(String name,int number) {
		this.name = name;
		this.number = number;
	}
	
	
	/////////////////////////// getters, setters 메뉴 사용
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected int getNumber() {
		return number;
	}
	protected void setNumber(int number) {
		this.number = number;
	}
}
