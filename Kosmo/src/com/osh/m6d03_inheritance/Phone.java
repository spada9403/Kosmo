package com.osh.m6d03_inheritance;

public class Phone {
	
	String model;
	String color;
	String no;
	
	public Phone(String m, String c, String n) {
		this.model = m;
		this.color = c;
		this.no = n;
	}
	
	public void powerOn() {System.out.println("전원 ON");}
	public void powerOff() {System.out.println("전원 OFF");}
	public void ring() {System.out.println("전화벨 울림.");}
	public void send() {System.out.println("메세지 보냄.");}
}
