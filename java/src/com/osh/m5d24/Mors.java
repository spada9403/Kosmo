package com.osh.m5d24;

import java.util.Scanner;

public class Mors {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] mors = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", // A,B,C,D,E,F,G
				"....", "..", ".---", "-.-", ".-..", "--", "-.", // H,I,J,K,L,M,N
				"---", ".--.", "--.-", ".-.", "...", "-", "..-", // O,P,Q,R,S,T,U
				"...-", ".--", "-..-", "-.--", "--.." }; // V,W,X,Y,Z

		String[] input = sc.nextLine().toUpperCase().split("");

		// A~Z를 벗어난 값을 거릅니다.
		for (String ch : input) {
			if (((ch.charAt(0)) - 65) > 25 || ((ch.charAt(0)) - 65) < 0) {
				if ((" ".equals(ch))) {
					continue;
				}
				System.out.println(" Out of value: 'A'~'Z' 까지 입력해주세요.");
				return;
			}
		}

		// 모스부호를 출력합니다.
		for (String ch : input) {
			if (" ".equals(ch)) {
				continue;
			} else {
				System.out.print(mors[(ch.charAt(0)) - 65] + " ");
				System.out.println((int) ('Z' - 'A'));
			}
		}
	}
}
