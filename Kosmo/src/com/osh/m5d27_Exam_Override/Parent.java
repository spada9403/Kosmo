package com.osh.m5d27_Exam_Override;

public class Parent {
	protected String name;
	protected Parent(String name) {
		this.name = name;
	}
	public void info() {
		System.out.println(name + "가족입니다.");
	}
}
