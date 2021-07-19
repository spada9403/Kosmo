package com.osh.day4;

public class Complex_Assignment_Operator {

	public static void main(String[] args) {
		int num = 2;
		// +=
		num += 2;
		System.out.println(num);
		// -=
		num -= 2;
		System.out.println(num);
		// *=
		num *= 2;
		System.out.println(num);
		// /=
		num /= 2;
		System.out.println(num);
		// %=
		num %= 2;
		System.out.println(num);
		// <<= 비트 연산자. 비트 왼쪽이동 후 대입.
		num += 2;
		num <<= 2;
		System.out.println(num);
		// >>= 비트 오른쪽이동 후 대입.
		num >>= 2;
		System.out.println(num);
		// >>>=
		num += 12;
		num >>>= 2;
		System.out.println(num);
		int num2 = 8;
		// &=
		num &= num2;
		System.out.println(num);
		// |=
		num |= num2;
		System.out.println(num);
		// ^=
		num ^= num2;
		System.out.println(num);

	}

}
