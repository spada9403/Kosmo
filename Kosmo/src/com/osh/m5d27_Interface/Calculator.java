package com.osh.m5d27_Interface;

public abstract class Calculator  implements Calc{ // 클래스에서 인터페이스를 구현 하는방법.
										// extends 대신 implements을 사용한다.
	/*
	 * Calc 인터페이스를 Calculator 클래스로 구현 한다고 했으므로, 추상메소드로 변환된 인터페이스에서 선언한 메소드들을 작성해야 한다.
	 * 혹은 Calculator 클래스를 추상 메소드로 만든다.
	 */
	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	@Override
	public int substract(int num1, int num2) {
		return num1 - num2;
	}
	// 아직까진 인터페이스의 times(), divide()를 구현하지 않았으므로 추상 클래스이다. 즉, new 생산자를 사용할수 없다.
}


class CompleateCalc extends Calculator {
	@Override
	public int times(int num1, int num2) {
		return num1* num2;
	}
	@Override
	public int divide(int num1, int num2) {
		if(num2 != 0) {
			return num1/num2;
		} else {
			return Calc.ERROR;
		}
	}
	public void showInfo() {
		System.out.println("Calc 인터페이스를 구현하였습니다.");
	}
}
