package com.osh.m5d27;

public class VIPCustomer extends Customer {
	private int agentID;
	double saleRatio;
	
	
	public VIPCustomer() {
		setCustomerGrade("VIP");
		bonusRatio = 0.05;
		saleRatio = 0.1;
		agentID = 010110;
		
	}
	
	
	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price -(int)(price*bonusRatio);
	}
	
	public int getAgentID() {
		return agentID;
	}
	
}
