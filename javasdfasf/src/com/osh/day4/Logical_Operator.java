package com.osh.day4;

public class Logical_Operator {

	public static void main(String[] args) {

		System.out.println((5 > 3) && (5 > 2));
		System.out.println((5 < 3) || !(5 < 2));
		System.out.println(!true);

		int num1 = 10;
		int i = 2;
		boolean value = ((num1 += 10) < 10) && ((i += 2) < 10); // 둘중에 하나만 거짓이어도 거짓.(&&) 앞 문장이 거짓이므로 뒷문장은 실행되지 않음.
		System.out.println(value);
		System.out.println(num1);
		System.out.println(i);

		value = ((num1 += 10) > 10) || ((i += 2) < 10); // 둘중에 하나만 참이어도 참.(||) 앞 문장이 참이므로 뒷문장은 실행되지 않음.
		System.out.println(value);
		System.out.println(num1);
		System.out.println(i);
	}

}
