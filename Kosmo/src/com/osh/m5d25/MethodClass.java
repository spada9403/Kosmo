package com.osh.m5d25;

public class MethodClass {

	public int add(int i1, int i2) {
		int result;
		result = i1 + i2;
		return result;
		// return i1 + i2;
	}

	public int getTenTotal() {
		return 10 * 10; // 값만 반환
	}

	public void printTenTotal() {
		int total = getTenTotal();
		System.out.println(total);
		// return; 생략 가능.
	}

	public void printGreeting(String name) {
		System.out.println("Hello" + name);
		return; // 반환 값이 없다는 의미. void.
	}

	public void divide(int num1, int num2) {
		if (num2 == 0) {
			System.out.println("나누는 수는 0이 될 수 없습니다.");
			return; // 함수 수행 종료. break 와 유사.
		} else {
			int result = num1 / num2;
			System.out.println(result);
		}
	}
}
