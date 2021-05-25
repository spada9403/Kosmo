package com.osh.day5_Homework;

import java.util.Scanner;

public class Homework2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����1 �Է�");
		int num1 = sc.nextInt();
		System.out.println("������ �Է�");
		sc.nextLine();
		String str = sc.nextLine();
		System.out.println("����2 �Է�");
		int num2 = sc.nextInt();

		switch (str) {
		case "+":
			System.out.println("Plus���: " + (num1 + num2));
			break;
		case "-":
			System.out.println("Minus���: " + (num1 - num2));
			break;
		case "*":
			System.out.println("*���: " + (num1 * num2));
			break;
		case "/":
			System.out.println("/���: " + (num1 / num2));
			break;
		default:
			System.out.println("�Է��� �̻��մϴ�.");
		}
	}

}
