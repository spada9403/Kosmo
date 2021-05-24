package com.osh.day6_Homework;
import java.util.Scanner;
public class HomeWork_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 1번
		/*
		int n = sc.nextInt();
		int num1 = 1;
		int sum = 0;
		int count = 0;
		while(true) {
			if(num1 % 2 == 1) {
				sum += num1;
				count++;
				if(sum >= n) {
					System.out.println("지금까지 더해진 홀수의 개수 : " + count);
					System.out.println("지금까지 더해진 홀수의 총합 : " + sum);
					break;
				}
			}
			num1++;
		}
		*/
		// 모래시계 만들기
		
		/*
		int num1 = sc.nextInt();
		int count = 0;
		int num2 = 1;
		int star = 0;
		
		//num2(별 갯수) 구하기.
		while(true) {
			if(num2%2 == 1) {
				count++;
				if(count == num1) {
					star = num2;
					break;
				}
			}
			num2++;
		}
		// 모래시계 만들기
		for(int i = 0; i < num1; i++) {
			for(int jo = 0; jo < ((star-num2)/2); jo++) {
				System.out.print(" ");
			}
			for(int j = 0; j < num2;j++) {
				System.out.print("*");
			}
			System.out.println("");
			if(num2 == 1) {
				for(int t = 0; t < num1-1; t++) {
					num2 += 2;
					for(int jo = 0; jo < ((star-num2)/2); jo++) {
						System.out.print(" ");
					}
					for(int j = 0; j < num2;j++) {
						System.out.print("*");
					}
					System.out.println("");
				}
			}
			num2 -= 2;
		}
		*/
		
		// 마지막 과제
		
		int multiIndex = sc.nextInt();
		
		
		int index = 0;
		int[][] multiArray = new int[multiIndex][multiIndex];
		int[] oddNumber = new int[] {1,3,5,7,9};
		
		for(int i =0 ; i < multiArray.length; i ++) {
			for(int j = 0; j < multiArray[i].length;j++) {
				multiArray[i][j] = oddNumber[index];
				index++;
				if(index == oddNumber.length) {
					index = 0;
				}
				System.out.print(j == multiArray[i].length ? multiArray[i][j] : multiArray[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
