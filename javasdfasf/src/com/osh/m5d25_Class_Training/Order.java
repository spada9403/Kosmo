package com.osh.m5d25_Class_Training;

public class Order {

	int OrderNumber;
	String OrderId;
	String OrderDate;
	String OrderName;
	String OpNumber;
	String OrderLocation;

	public Order setOrder(int ON, String OI, String OD, String OName, String OPN, String ORL) {
		Order a = new Order();
		a.OrderNumber = ON;
		a.OrderId = OI;
		a.OrderDate = OD;
		a.OrderName = OName;
		a.OpNumber = OPN;
		a.OrderLocation = ORL;

		return a;
	}

	public String[] getOrder() {
		String[] list = { Integer.toString(OrderNumber), OrderId, OrderDate, OrderName, OpNumber, OrderLocation };
		return list;
	}
}
