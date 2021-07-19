package com.osh.m5d27_Exam_Customer_Polymorphism;

public class Customer {
	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	double bonusRatio;
	
	public Customer() {
		initCustomer();
	}
	public Customer(int customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;
		initCustomer();
	}
	private void initCustomer() {
		customerGrade = "SILVER";
		bonusRatio = 0.01;
	}
	
	
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price;
	}
	
	public String showCustomerInfo() {
		return customerName + " 님의 등급은 " + customerGrade + "이며, 보너스 포인트는" + bonusPoint + "점 입니다.";
	}
	protected int getCustomerID() {
		return customerID;
	}
	protected void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	protected String getCustomerName() {
		return customerName;
	}
	protected void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}
