package com.osh.day4;

public class TypeCastingEX1 {
	public static void main(String[] args) {
		// 암묵적 타입캐스팅.
		byte b = 25;
		short s = b;
		int i = s;
		long l = i;

		float f = i;
		double d = f;
		System.out.println("b = " + b);
		System.out.println("s = " + s);
		System.out.println("i = " + i);
		System.out.println("l = " + l);
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		// 명시적 타입캐스팅. 강제성
		byte b1 = (byte) 256;
		System.out.println(b1);

		double dNum1 = 1.2;
		float fNum1 = 0.9F;

		int iNum3 = (int) dNum1 + (int) fNum1;
		int iNum = (int) (dNum1 + fNum1);
		System.out.println(iNum3);
		System.out.println(iNum);
	}
}
