package com.osh.day5;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		System.out.println("이름");
		String name = sc.nextLine();
		System.out.println("직업");
		String job = sc.nextLine();
		System.out.println("사번");
		int num = sc.nextInt();
		sc.close();
		
		System.out.println(name);
		System.out.println(job);
		System.out.println(num);
		*/
		System.out.println("양수 3개 입력 : ");

		while(true) {
			try {
				int a= sc.nextInt();
				int b= sc.nextInt();
				int c= sc.nextInt();
				if ((a <= 0) || (b <= 0) || (c <= 0)) {
					System.out.println("다시해봐. 양수만 넣으라고 했잖아?");
					break;
				} else {
					System.out.println("sum : " + (a+b+c));
					System.out.println("avg : " + ((a+b+c)/3));	
				}
			} catch (Exception e) {	
				System.out.println("Fucking got dame it");
			}
		}
	}

}
