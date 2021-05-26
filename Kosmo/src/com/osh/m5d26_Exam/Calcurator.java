package com.osh.m5d26_Exam;

public class Calcurator {

	protected int op1;
	protected int op2;
	
	public void setOperand(int op1, int op2) {
		this.op1 = op1;
		this.op2 = op2;
	}
	
	public int sum() {
		return this.op1 + this.op2;
	}
	
	public double avg() {
		return (double)((this.op1 + this.op2) / 2);
	}
	
}
