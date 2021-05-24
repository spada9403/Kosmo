package com.osh.day4;

public class Sign_Operator {

	public static void main(String[] args) {
		int num = -2147483648;
		System.out.println(+num);
		System.out.println(-num);
		System.out.println(num);
		
		num = +num;
		System.out.println(num);
		
		// 실수
		
		double dNum = 3.14;
		
		System.out.println(+dNum);
		System.out.println(-dNum);
		System.out.println(dNum);
		
		dNum = -dNum;
		
		System.out.println(dNum);
	}

}
