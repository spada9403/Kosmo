package com.osh.day5;

import java.util.Scanner;

public class LoopExam {
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("단을 입력해주세요");
		
		int dan = sc.nextInt();
		int index = 1;
		//while 문으로 구구단
		while(index < 10) {
			System.out.println( (dan) + " * " + (index) + " = " + (dan*index));
			index++;
		}
		//for 문으로 구구단
		for(int i = 1;i<10;i++) {
			System.out.println( (dan) + " * " + (i) + " = " + (dan*i));
		}
		*/
		//위에것들 응용 무한루프

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("단을 입력해주세요");
			
			int dan = sc.nextInt();
			if(dan == -1) {
				System.out.println("~끝~");
				break;
			}
			int index = 1;
			
			while(index < 10) {
				System.out.println( (dan) + " * " + (index) + " = " + (dan*index));
				index++;
			}
		}
		// 121p break 반복 탈출 예제
		int sum = 0;
		int num;
		
		for(num = 0;;num++) {
			sum += num;
			if(sum >= 100) break;
		}
		System.out.println("num : " + num);
		System.out.println("sum : "+ sum);
		//p119쪽
		
		int total = 0;
		int num1;
	
		for(num = 1;num <=100; num++) {
			if(num %2 == 0) {
				continue;
			}
			total +=num;
		}
		System.out.println("1부터 100까지의 홀수의 합은 : " + total + "입니다.");
	}
}
