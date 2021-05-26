package com.osh.m5d26_Exam;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자입력 : ");
		int n = sc.nextInt();
		
		Prime p = new Prime(n);
		
		if(p.target == 0) {
			System.out.println("숫자입력 : ");
			n = sc.nextInt();
			p.setNumber(n);
			p.print();
		} else {
			p.print();
		}
		
	}

}
