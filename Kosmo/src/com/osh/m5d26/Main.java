package com.osh.m5d26;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자입력 : ");
		int n = sc.nextInt();
		
		Prime p = new Prime(n);
		
		p.print();
		
		if(p.target == 0) {
			System.out.println("숫자를 다시 입력해주세요 : ");
			n = sc.nextInt();
			p.target = n;
		}
		
	}

}
