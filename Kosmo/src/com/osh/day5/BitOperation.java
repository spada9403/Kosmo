package com.osh.day5;

public class BitOperation {

	public static void main(String[] args) {
		int num1 = 3; // 0011
		int num2 = 10;// 1010
		
		int result = num1 & num2 ; // 0010
		System.out.println(result);
		result = num1 | num2; // 1011 둘다 0이면 0 외에는 1.
		System.out.println(result);
		result  = ~num1; // 1100(부호비트 주의!) 1(부호비트)100 = -4
		System.out.println(result);
		result = num1 ^ num2; // 두 비트가 달라야지만 1 0011 ^ 1010 = 1001
		System.out.println(result);
		// 논리 연산자와 비트 논리 연산자 차이
		boolean t = (num1 >= num2) && (num1 <= num2);
		//t = (num1 & num2) && (num1 ^ num2); 항이 true false 가 아닌 실제 값이 나오기 때문에 논리연산자 항으로 맞지않음. 에러!!
		// boolean 값도 비트연산이 가능!
		t = (5 > 10) & (10 < 20);
		System.out.println(t);
		t = (5 < 10) & (10 < 20);
		System.out.println(t);
		/*
		 * shift operator
		 * bit wise operation
		 *  - left, right, 0채움
		 *  << 연산자 = 왼쪽으로 n 비트 이동 > 기존 값에 2^n 곱한다. (5 << 2 => 5 * 2^2 => 20) 0101 > 10100
		 *  >> 연산자 = // 기존값에 2^n 나눈다.
		 *  >>> 연산자 = >> 연산과 같다. 하지만 채워지는비트값이 부호비트와 상관없이 무조건 0 이된다
		 */
		
		int num3 = 5;
		int num4 = -5;
		
		System.out.println(num3 << 3);
		System.out.println(num4 << 3);
		
		System.out.println(num3 >> 2);
		System.out.println(num4 >> 2);
		
		System.out.println(num4 >>> 1);
		System.out.println(num3 >>> 1);
	}

}

/*
		1010 = 10
		1011 = 7
	   &1010 = 10
	   |1011 = 11
	   ^0001 = 1
    !10~0101 = 4

*/