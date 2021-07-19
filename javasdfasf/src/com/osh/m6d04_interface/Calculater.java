package com.osh.m6d04_interface;

public class Calculater implements calc {

	@Override
	public int add(int n1, int n2) {
		return n1 + n2;
	}

	@Override
	public int substract(int n1, int n2) {
		return n1 - n2;
	}

	@Override
	public int times(int n1, int n2) {
		return 0;
	}

	@Override
	public int divide(int n1, int n2) {
		return 0;
	}

}
