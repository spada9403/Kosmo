package com.osh.m5d26;

public class VIPCustomer extends Customer {
	private int agentID;
	double saleRatio;
	
	
	public VIPCustomer() {
		setCustomerGrade("VIP");
		bonusRatio = 0.05;
		saleRatio = 0.1;
		agentID = 010110;
		
		System.out.println("VIP Customer() 생성자 호출.");
	}
	
	public int getAgentID() {
		return agentID;
	}
	
}
