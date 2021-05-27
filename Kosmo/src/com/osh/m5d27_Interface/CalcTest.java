package com.osh.m5d27_Interface;

public class CalcTest {

	public static void main(String[] args) {

		int num1 = 10;
		int num2 = 5;
		CompleateCalc calc = new CompleateCalc();
		/*
		 * CompleateCacl 는 Calc형과 Calculator 형으로 묵시적 형변환이 가능하다.
		 * 형 변환이 가능은 하나 CompleateCalc 에서 추가된 메서드인 showInfo() 메서드는
		 * 사용 불가능하고, Calc 인터페이스 에서 선언된 메소드 들만 사용 가능함.
		 */
		System.out.println(calc.add(num1, num2));
		System.out.println(calc.substract(num1, num2));
		System.out.println(calc.times(num1, num2));
		System.out.println(calc.divide(num1, num2));
		calc.showInfo();
		
	}

}
