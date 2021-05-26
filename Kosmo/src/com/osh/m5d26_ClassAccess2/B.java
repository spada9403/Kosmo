package com.osh.m5d26_ClassAccess2;

public class B { // public 다른 패키지에서도 접근 가능.
	protected int n; // 같은 패키지 안에서만 접근 가능.
	protected void g() {
		n = 5;
	}
	public int a;
}
