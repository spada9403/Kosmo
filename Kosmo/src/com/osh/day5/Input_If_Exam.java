package com.osh.day5;

import java.util.Scanner;

public class Input_If_Exam {

	public static void main(String[] args) {
		//실습
		//Scanner, if statement 사용
		//숫자가 0, 부호 - 가 아니면 숫자를 출력.
		// 0, -부호면 메시지 "양수를 입력하세요!" 출력!
		//종료
		
		Scanner sc = new Scanner(System.in);
		
		int a;
		
		while(true) {
			System.out.println("양수를 입력하세요 : ");
			a = sc.nextInt();
			if (a <= 0) {
				System.out.println("양수를 입력하세요!!");
			} else {
				if(a == 100) {
					break;
				}
				System.out.println(a);
			}
		}
		sc.close();
		
		Scanner sc2 = new Scanner(System.in);
		
		int b = sc2.nextInt();
		
		if (b >0) {
			System.out.println("양수");
		} else if(b < 0) {
			System.out.println("음수");
		} else if(b == 0){
			System.out.println("0입니다.");
		} else {
			System.out.println("대체 뭘 준건가");
		}
		
	}

}
