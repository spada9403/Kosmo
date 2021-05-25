package com.osh.day4_bonus;

import java.util.Scanner;

public class InputExam {

	public static void main(String[] args) {

		// 첫번째 실습 문제.
		/*
		 * if(args.length==3) { int sum = 0; for(String i:args) { try { int a =
		 * Integer.parseInt(i); sum += a; } catch (Exception e) {
		 * System.out.println("Please give me the NUMBER!!"); return; } }
		 * System.out.println("SUM : "+ sum); System.out.println("AVG : "+ sum /
		 * args.length); } else { System.out.println("매개변수 3개를 정수로 입력해주세요."); }
		 */

		// 두번째 실습 문제.
		/*
		 * if(args.length==2) { int i1 = Integer.parseInt(args[0]) + 100; int i2 =
		 * Integer.parseInt(args[1]) % 10; System.out.println(i1);
		 * System.out.println(i2); } else { System.out.println("매개변수 2개를 정수로 입력해주세요.");
		 * }
		 */

		// 3번째 실습문제.
		/*
		 * if(args.length==2) { int i1 = Integer.parseInt(args[0]); int i2 =
		 * Integer.parseInt(args[1]); System.out.println(i1 + " / " + i2 + " = " + (i1 /
		 * i2) + "..." + (i1 % i2)); } else {
		 * System.out.println("매개변수 2개를 정수로 입력해주세요."); }
		 */

		// 교재 88Page 문제 완성.
		/*
		 * int myAge = 23; int teacherAge = 38;
		 * 
		 * boolean value = (myAge > 25); System.out.println(value);
		 * 
		 * System.out.println(myAge <= 25); System.out.println(myAge == teacherAge);
		 * 
		 * char ch; ch = (myAge > teacherAge) ? 'T' : 'F';
		 * 
		 * System.out.println(ch);
		 */

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자1 입력");
		int num1 = sc.nextInt();
		System.out.println("연산자 입력");
		char str = sc.next().charAt(0);
		System.out.println("숫자2 입력");
		int num2 = sc.nextInt();

		switch (str) {
		case '+':
			System.out.println("Plus결과: " + (num1 + num2));
			break;
		case '-':
			System.out.println("Minus결과: " + (num1 - num2));
			break;
		case '*':
			System.out.println("*결과: " + (num1 * num2));
			break;
		case '/':
			System.out.println("/결과: " + (num1 / num2));
			break;
		default:
			System.out.println("입력이 이상합니다.");
		}
	}
}
