package com.osh.m5d27_Exam_Override;

public class Child extends Parent{
	private int stID;
	
	protected Child(String name, int stID) {
		super(name); // Paret 부모클래스의 생성자를 불러와야 하는데 기본(디폴트) 생성자가 없기 때문에 오류가난다. 
		this.name = name;
		this.stID = stID;
	}
	
	@Override
	public void info() {
		System.out.println(super.name + "가족의 " + this.name + "입니다.");
	}
}
