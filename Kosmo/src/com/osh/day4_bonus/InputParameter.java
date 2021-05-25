package com.osh.day4_bonus;

public class InputParameter {

	public static void main(String[] args) {
		System.out.println("Length : " + args.length);
		//
		int sum = 0;
		for (String i : args) {
			System.out.println(i);
			System.out.println(i instanceof String);
			int a = Integer.parseInt(i);
			sum += a;
			System.out.println(sum);
		}
	}

}
