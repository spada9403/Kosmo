package com.osh.day5;

public class practice {

	public static void main(String[] args) {
		// 90p 2
		int num;
		num = -5 + 3 * 10 / 2;
		System.out.println(num);
		// 3
		num = 10;
		System.out.println(num);
		System.out.println(num++);
		System.out.println(num);
		System.out.println(--num);
		// 4
		int num2 = 20;
		boolean result;

		result = ((num > 10) && (num2 > 10));
		System.out.println(result);
		result = ((num > 10) || (num2 > 10));
		System.out.println(result);
		System.out.println(!result);
		// 5
		num = 2;
		num2 = 10;

		System.out.println(num);
		System.out.println(num | num2);
		System.out.println(num ^ num2);
		System.out.println(~num); // ??
		// 6
		num = 8;
		System.out.println(num += 10);
		System.out.println(num -= 10);
		System.out.println(num >>= 2);
		// 7
		num = 10;
		num2 = 20;

		int result1 = (num >= 10) ? num2 + 10 : num2 - 10;
		System.out.println(result1);
	}

}
