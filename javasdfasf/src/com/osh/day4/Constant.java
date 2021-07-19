package com.osh.day4;

public class Constant {
	public static void main(String[] args) {
		// 값 변경이 안되는 식별자! (변수) => 상수 Constant.
		// 값을 미리 정하고(선언하고) 사용하는 목적! 이유는 메모리 확보.

		final double PI = 3.14;
		// 리터럴 => 변수나 상수 값으로 대입되는 모든 값들.
		// PI = 3.15;
		System.out.println(PI);
	}
}
