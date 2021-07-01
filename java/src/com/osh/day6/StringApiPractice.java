package com.osh.day6;

import java.util.Scanner;

public class StringApiPractice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("계산식을 입력하세요 : ");
		String calc = sc.nextLine();

		String[] strs = calc.split(" ");

		try {
			if (strs.length < 3) {
				System.out.println("잘못된 입력. int operator int 입력해주세요.");
			} else {
				if (strs[1].equals("+")) {
					System.out.println(Integer.parseInt(strs[0]) + Integer.parseInt(strs[2]));
				} else if (strs[1].equals("-")) {
					System.out.println(Integer.parseInt(strs[0]) - Integer.parseInt(strs[2]));
				} else if (strs[1].equals("*")) {
					System.out.println(Integer.parseInt(strs[0]) * Integer.parseInt(strs[2]));
				} else if (strs[1].equals("/")) {
					System.out.println(Integer.parseInt(strs[0]) / Integer.parseInt(strs[2]));
				} else {
					System.out.println("피연산자 연산자 피연산자 입력해주세요. 없는 연산자 입력받앗습니다.");
				}
			}
		} catch (Exception e) {
			System.out.println("피연산자는 숫자만 입력해주세요.");
		}
	}

}
