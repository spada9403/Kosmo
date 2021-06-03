package com.osh.m6d03_inheritance;

public class AirplaneEx {

	public static void main(String[] args) {
		Airplane plane = new Airplane();
		plane.takeOff();
		plane.fly();
		plane.land();
		
		Supersonic splane = new Supersonic();
		splane.takeOff();
		splane.fly();
		splane.setMode(false);
		splane.fly();
		splane.setMode(true);
		splane.fly();
		splane.land();
		
	}

}
