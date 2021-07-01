package com.osh.m5d27_Exam_BusAndTaxi;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		
		Driver d = new Driver();
		
		list.add(new Bus());
		list.add(new Taxi());
		list.add(new Bus());
		list.add(new Taxi());
		list.add(new Bus());
		
		for(Vehicle D : list) {
			d.drive(D);
		}
		
	}

}
