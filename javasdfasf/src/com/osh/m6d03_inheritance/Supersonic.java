package com.osh.m6d03_inheritance;

public class Supersonic extends Airplane{
	
	public final static boolean NORMAL = true;
	public final static boolean SUPERSONIC = false;
	
	public boolean mode;
	
	public Supersonic() {
		this.mode = NORMAL;
	}

	@Override
	public void fly() {
		if(mode) {
			System.out.println("일반비행");
		} else {
			System.out.println("초음속비행");
		}
	}
	
	public void setMode(boolean mode) {
		this.mode = mode;
	}
	
}
