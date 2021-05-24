package com.osh.Day8_0521_Homework;

import java.util.Scanner;

public class SortArray {

	public static void main(String[] args) {
		/*
		 * 100 개의 정수를 저장할수 있는 배열을 선언하고 정수를 차례대로 입력받다가 0 이 입력되면
		 * 0을 제외하고 그 떄 까지 입력된 정수를 가장 나중에 입력된 정수부터 차례대로 출력하는 프로그램.
		 */
		
		
		Scanner sc = new Scanner(System.in);
		
		// 배열선언
		int intArray[] = new int[100];
		
		// 배열의 갯수만큼 입력받기.
		for(int i = 0; i < intArray.length; i++) {
			intArray[i] = sc.nextInt();
			// 0입력 검증
			if(intArray[i] == 0) {
				for(int j = i-1; j>=0;j--) {
					System.out.print(intArray[j] + " ");
				}
				break;
			}
		}
}
}

/*
 * // 배열 바꾸기. << 할필요가 없이 index를 거꾸로 출력하면 된다.
				int Temp = 0;
				// 0을 제외한 배열의 갯수 저장. (출력을위함.)
				int count = i-1;
				// 상반된 위치에 있는 배열을 바꿈. 
				for(int j= 0; j <=((i-1)/2);j++) {
					Temp = intArray[j];			// 잠시 다른 변수에 첫번째 배열 저장. // 작동 제대로 안됨
					intArray[j] = intArray[i-1];	// 0을 제외한 마지막 배열을 첫번째 배열로 이동.
					intArray[i-1] = Temp;			// 잠시 저장했던 첫번째 배열을 마지막배열로 이동.
					i--;
				}
				// 배열 정리가 끝났으면 출력하고 종료하기.
				for(int j = 0; j <= count; j++) {
					// 한칸씩 공백 만들어주다가 마지막 출력에선 공백 멈추기.
					System.out.print(j==count ? intArray[j]:intArray[j] + " ");
				}
				break;
 */
