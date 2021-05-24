package com.osh.day4;

public class Double_FloatEX1 {

	public static void main(String[] args) {
		double dnum = 3.14;
		float fnum = 3.14F;
		
		double dnum2 = -3.14;
		float fnum2 = -3.14F;
		
		System.out.println(dnum);
		System.out.println(fnum);
		System.out.println(dnum2);
		System.out.println(fnum2);
		// float to int
		System.out.println("double2long: " + (long)dnum2);
		//long l1 = dnum2;
		System.out.println("double2long: " + (int)dnum2);
		//int i1 = dnum2;
		System.out.println("double2long: " + (short)dnum2);
		// short s1 = dnum2;
		System.out.println("double2long: " + (byte)dnum2);
		// byte b1 = dnum2;
		
		//int to float/double
		
		int i1 = 32768;
		int i2 = 2147483647;
		int i3 = -2147483648;
		double dnum3 = i1;
		double dnum4 = i2;
		double dnum5 = i3;
		System.out.println(dnum3);
		System.out.println(dnum4);
		System.out.println(dnum5);
		System.out.println((float)i2);
		double dnum6 = 1;
		for(int i = 0; i< 10000; i++) {
			dnum6 +=0.1;
		}
		System.out.println(dnum6);
	}

}
