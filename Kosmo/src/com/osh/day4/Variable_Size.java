package com.osh.day4;

public class Variable_Size {
	public static void main(String[] args) {
		/*
		 모든 변수의 최대값은 각 변수가 가지는 최대값
		 ex) byte형은 1byte로 8비트이다. 컴퓨터는 0부터 숫자를 셈하므로
		 2^7-1  ~  -2^7 의 수를 담을수 있다.  
		 */
		// Byte 형: 1 Byte
		byte bs1 = -128;
		byte bs2 = 127;
		// short : 2 Byte
		short sh1 = 32767;
		short sh2 = -32768;
		// Int 형 : 4 Byte
		int int1 = 2147483647;
		int int2 = -2147483648;
		// long형 : 8 Byte 자바에선 기본적으로 int형으로 처리하기때문에 L리터럴을 붙여줘서 long형으로 처리하라고 얘기해준다.
		long long1 = 9223372036854775807L;
		long long2 = -9223372036854775808L;
	}
}
