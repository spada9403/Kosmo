package com.osh.Day8_0521_Homework;

import java.util.Scanner;

public class NumberStairs {

	public static void main(String[] args) {
		/*
		 * 자연수 N을 입력받아 "출력 예"와 같이 공백으로 구분하여 출력하는 프로그램을 작성하시오. 주의! 숫자를 공백으로 구분하되 줄사이에 빈줄은
		 * 없다.
		 */

		Scanner sc = new Scanner(System.in);

		System.out.println("자연수 N을 입력해주세요 : ");
		int n = sc.nextInt();

		int[][] intArray = new int[n][n];

		for (int i = 1; i <= intArray.length; i++) {
			int count = 1;

			for (int j = 0; j < intArray.length; j++) {
				if (j == (intArray.length - i)) {
					for (; j < intArray.length; j++) {
						intArray[i - 1][j] = count;
						count++;
					}
				} else {
					System.out.print(" ");
				}
			}

			for (int a : intArray[i - 1]) {
				if (a != 0) {
					System.out.print(a);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
/*
 * // 줄바꿈 반복문 for(int i = 1; i <= n; i++) { // 공백 채우기 for(int j = 0; j < n-i;
 * j++) { System.out.print("  "); } //숫자 찍기 for(int j = 1;j<=i;j++){
 * System.out.print((i == j) ? j:j + " "); } System.out.println(); }
 */
