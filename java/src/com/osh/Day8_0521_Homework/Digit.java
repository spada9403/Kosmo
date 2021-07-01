package com.osh.Day8_0521_Homework;

import java.util.Scanner;

public class Digit {

	public static void main(String[] args) {
		/*
		 * 100 미만의 양의 정수들이 주어진다. 입력받다가 0이 입력되면 마지막에 입력된 0 을 제외하고 그 때 까지 입력된 정수의 십의자리 숫자가
		 * 각각 몇개인지 작은 수부터 출력하는 프로그램을 작성해라. (0은 출력하지 않는다.)
		 */

		Scanner sc = new Scanner(System.in);

		// 갯수를 구하기 위한 배열 선언과 사용하기 위한 초기화.
		int DigitGroup[] = new int[10];

		// 이 방법으로는 각 배열들을 초기화 할수가 없다..!
		// for(int num : DigitGroup) { // 향상된 For문은 오로지 꺼내쓸수있지 수정할수는 없다.
		// num = 0;
		// }

		for (int i = 0; i < DigitGroup.length; i++) {
			DigitGroup[i] = 0;
		}

		// 반복입력.
		while (true) {
			// 입력된 양수를 잠시저장할 변수 Temp
			int Temp;

			Temp = sc.nextInt();

			// 입력받은 수의 범위 확인.
			if (Temp < 0 || Temp >= 100) {
				System.out.println("1~100의 범위를 벗어났습니다.");
				continue;
			}
			// 0 입력을 확인하고 출력하기.
			if (Temp == 0) {
				for (int i = 0; i < DigitGroup.length; i++) {
					if (DigitGroup[i] == 0) {
						continue;
					} else {
						System.out.println(i + " : " + DigitGroup[i]);
					}
				}
				break;
			}

			// 자릿수 카운트.
			switch (Temp / 10) {
			case 0:
				DigitGroup[0] += 1;
				break;
			case 1:
				DigitGroup[1] += 1;
				break;
			case 2:
				DigitGroup[2] += 1;
				break;
			case 3:
				DigitGroup[3] += 1;
				break;
			case 4:
				DigitGroup[4] += 1;
				break;
			case 5:
				DigitGroup[5] += 1;
				break;
			case 6:
				DigitGroup[6] += 1;
				break;
			case 7:
				DigitGroup[7] += 1;
				break;
			case 8:
				DigitGroup[8] += 1;
				break;
			case 9:
				DigitGroup[9] += 1;
				break;
			}
		}
	}

}
