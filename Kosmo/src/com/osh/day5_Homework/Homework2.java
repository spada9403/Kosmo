package com.osh.day5_Homework;

import java.util.Scanner;

public class Homework2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자1 입력");
		int num1 = sc.nextInt();
		System.out.println("연산자 입력");
		sc.nextLine();
		String str = sc.nextLine();
		System.out.println("숫자2 입력");
		int num2 = sc.nextInt();
		
		switch (str) {
		case "+":
			System.out.println("Plus결과: "+(num1+num2));
			break;
		case "-":
			System.out.println("Minus결과: "+(num1-num2));
			break;
		case "*":
			System.out.println("*결과: "+(num1*num2));
			break;
		case "/":
			System.out.println("/결과: "+(num1/num2));
			break;
		default:
			System.out.println("입력이 이상합니다.");
		}
	}

}
