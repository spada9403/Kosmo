package com.osh.day5;

import java.util.Scanner;

public class LoopExam {
	public static void main(String[] args) {
		/*
		 * Scanner sc = new Scanner(System.in); System.out.println("���� �Է����ּ���");
		 * 
		 * int dan = sc.nextInt(); int index = 1; //while ������ ������ while(index <
		 * 10) { System.out.println( (dan) + " * " + (index) + " = " + (dan*index));
		 * index++; } //for ������ ������ for(int i = 1;i<10;i++) { System.out.println(
		 * (dan) + " * " + (i) + " = " + (dan*i)); }
		 */
		// �����͵� ���� ���ѷ���

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("���� �Է����ּ���");

			int dan = sc.nextInt();
			if (dan == -1) {
				System.out.println("~��~");
				break;
			}
			int index = 1;

			while (index < 10) {
				System.out.println((dan) + " * " + (index) + " = " + (dan * index));
				index++;
			}
		}
		// 121p break �ݺ� Ż�� ����
		int sum = 0;
		int num;

		for (num = 0;; num++) {
			sum += num;
			if (sum >= 100)
				break;
		}
		System.out.println("num : " + num);
		System.out.println("sum : " + sum);
		// p119��

		int total = 0;
		int num1;

		for (num = 1; num <= 100; num++) {
			if (num % 2 == 0) {
				continue;
			}
			total += num;
		}
		System.out.println("1���� 100������ Ȧ���� ���� : " + total + "�Դϴ�.");
	}
}
