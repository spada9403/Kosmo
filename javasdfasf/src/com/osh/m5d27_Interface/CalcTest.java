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
		Calc c = new Calc() {

			@Override
			public int add(int num1, int nim2) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int substract(int num1, int num2) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int times(int num1, int num2) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int divide(int num1, int num2) {
				// TODO Auto-generated method stub
				return 0;
			}
			/*
			 * 인터페이스를 클래스로 구현하는것 말고도, 
			 * 직접 메인메소드에서 코드를 짤수 있게 문법을 지원하고 있다.
			 * 여러가지 이벤트 들에서 인터페이스가 많이 쓰인다.
			 */
		}; // 세미콜론을 찍어줘야함.
		
	}

}
