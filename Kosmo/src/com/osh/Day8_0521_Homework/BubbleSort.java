package com.osh.Day8_0521_Homework;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		/*
		 * 내림차순 / 오름차순 정렬
		 */
		Scanner sc = new Scanner(System.in);

		int[] intArray = new int[5];

		// 5개의 정수 입력받기.
		System.out.println("정수 5개를 입력해주세요.");
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = sc.nextInt();
		}

		// 배열의 길이만큼 반복.
		for (int i = (intArray.length - 1); i >= 0; i--) {
			// 배열을 정렬할때 큰 숫자가 잠시 있을 변수.
			int Bigger = 0;
			// 배열의 정렬.
			for (int j = 0; j < i; j++) {

				// if문 조건식의 부호만 바꿔주면 내림차순/오름차순이다.
				if ((intArray[j]) < (intArray[j + 1])) {
					Bigger = intArray[j];
					intArray[j] = intArray[j + 1];
					intArray[j + 1] = Bigger;
				}
			}
		}
		// 정렬한 배열 출력
		for (int num : intArray) {
			System.out.print(num + " ");
		}
	}

}
