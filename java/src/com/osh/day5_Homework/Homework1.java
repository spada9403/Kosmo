package com.osh.day5_Homework;

public class Homework1 {

	public static void main(String[] args) {
		// page 100
		int score = 90;
		char grade;
		if (score >= 90) {
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		} else if (score >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		System.out.println("���� : " + grade);

		// page 106

		int floor = 3;

		switch (floor) {
		case 1:
			System.out.println("1�� �౹ �Դϴ�.");
			break;
		case 2:
			System.out.println("2�� �����ܰ� �Դϴ�.");
			break;
		case 3:
			System.out.println("3�� �Ǻΰ� �Դϴ�.");
			break;
		case 4:
			System.out.println("4�� ġ�� �Դϴ�.");
			break;
		case 5:
			System.out.println("5�� �ｺ Ŭ�� �Դϴ�.");
			break;
		default:
			System.out.println("���� �Է�.");
			break;
		}

		// page 123

		// q1
		int num1 = 10;
		int num2 = 2;
		char operator = '+';

		switch (operator) {
		case '+':
			System.out.println("result : " + (num1 + num2));
			break;
		case '-':
			System.out.println("result : " + (num1 - num2));
			break;
		case '*':
			System.out.println("result : " + (num1 * num2));
			break;
		case '/':
			System.out.println("result : " + (num1 / num2));
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + operator);
		}
		// q2
		for (int i = 1; i < 10; i++) {
			if ((i % 2) != 0) {
				continue;
			}
			for (int index = 1; index < 10; index++) {
				System.out.println(i + " * " + index + " + " + (i * index));
			}
		}
		// q3
		for (int i2 = 1; i2 < 10; i2++) {
			for (int index2 = 1; index2 < 10; index2++) {
				System.out.println(i2 + " * " + index2 + " = " + (i2 * index2));
				if (index2 == i2) {
					break;
				}
			}
		}
		// q4
		int maxWidth = 7;
		int star = 1;

		while (star <= maxWidth) {
			if (star % 2 != 0) {
				for (int count = 1; count <= ((maxWidth - star) / 2); count++) {
					System.out.print(" ");
				}
				for (int countStar = 1; countStar <= star; countStar++) {
					System.out.print("*");
				}
				System.out.println("");
			}
			star++;
		}
		// q5
		// int maxWidth = 9;
		// int star = 1;

		while (star <= maxWidth) {
			if (star % 2 != 0) {
				for (int count = 1; count <= ((maxWidth - star) / 2); count++) {
					System.out.print(" ");
				}
				for (int countStar = 1; countStar <= star; countStar++) {
					System.out.print("*");
				}
				System.out.println("");
			}
			star++;
			if (star == maxWidth) {
				while (star >= 1) {
					if (star % 2 != 0) {
						for (int count = 1; count <= ((maxWidth - star) / 2); count++) {
							System.out.print(" ");
						}
						for (int count = 1; count <= star; count++) {
							System.out.print("*");
						}
						System.out.println("");
					}
					star--;
				}
				if (star == 0) {
					break;
				}
			}
		}
	}
}
