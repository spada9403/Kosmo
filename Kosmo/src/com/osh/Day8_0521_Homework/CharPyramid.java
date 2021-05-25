package com.osh.Day8_0521_Homework;

import java.util.Scanner;

public class CharPyramid {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 자연수 n 입력받기
		System.out.println("자연수 3~ 10을 입력해주세요.");
		int n = sc.nextInt();
		char alphabet = 'A';

		char[][] strArray = new char[n][n];

		for (int i = 0; i < strArray.length; i++) {
			for (int j = 0; j < n; j++) {
				strArray[i][j] = alphabet;
				alphabet++;
				if (alphabet == 91) {
					alphabet = 'A';
				}
			}
			n--;
			for (char a : strArray[i]) {
				System.out.print(a);
			}
			System.out.println();
		}

	}

}

/*
 * //알파벳 시작점 설정. char alphabet = 'A';
 * 
 * // 줄반복. for(int i = 0; i < n; i++) { //자연수 범위 검증 if((n < 3) || (n >10)) {
 * System.out.println("입력한 자연수는 범위를 벗어났습니다."); break; } //알파벳 피라미드 //입력받은 자연수
 * n만틈 반복. for(int j = 0; j < (n-i) ; j++) { System.out.print(alphabet);
 * alphabet++; if(alphabet == 91) { alphabet = 'A'; } } System.out.println(); }
 */
