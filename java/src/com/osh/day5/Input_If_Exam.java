package com.osh.day5;

import java.util.Scanner;

public class Input_If_Exam {

	public static void main(String[] args) {
		// �ǽ�
		// Scanner, if statement ���
		// ���ڰ� 0, ��ȣ - �� �ƴϸ� ���ڸ� ���.
		// 0, -��ȣ�� �޽��� "����� �Է��ϼ���!" ���!
		// ����

		Scanner sc = new Scanner(System.in);

		int a;

		while (true) {
			System.out.println("����� �Է��ϼ��� : ");
			a = sc.nextInt();
			if (a <= 0) {
				System.out.println("����� �Է��ϼ���!!");
			} else {
				if (a == 100) {
					break;
				}
				System.out.println(a);
			}
		}
		sc.close();

		Scanner sc2 = new Scanner(System.in);

		int b = sc2.nextInt();

		if (b > 0) {
			System.out.println("���");
		} else if (b < 0) {
			System.out.println("����");
		} else if (b == 0) {
			System.out.println("0�Դϴ�.");
		} else {
			System.out.println("��ü �� �ذǰ�");
		}

	}

}
