package com.osh.m5d24;

import java.util.Arrays;
import java.util.Scanner;

public class StringMatch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] PetName = new String[] { "곰돌이", "복돌이", "흰둥이", "깨소금", "까만콩" };
		String[] NickName = new String[] { "Bear", "Gift", "White", "Sesami", "Black" };

		System.out.println("애완견 이름을 입력해주세요.");
		String input = sc.nextLine();

		for (int i = 0; i < 5; i++) {
			if (PetName[i].equals(input)) {
				System.out.println(NickName[i]);
			} else if (i == 4) {
				System.out.println("등록된 자료가 없습니다.");
			}
		}

		boolean b = false;

		for (String name : PetName) {
			if (name.equals(input)) {
				// Arrays.asList(array) >> 배열에 담겨있는 데이터들을 리스트로 만들어준다. indexOf사용가능.
				// array.indexOf 사용불가능. array는 배열의 위치를 알려주는것이기 때문에, 리스트, 혹은 문자열에서 검색해주는 IndexOf를
				// 사용할수 없다.
				// indexOf 는 객체(리스트)와 문자열에서 전달받은 인수를 검색해서 인덱스를 반환한다.
				// System.out.println(PetName);
				// System.out.println(Arrays.asList(PetName)); 비교해보자!
				// System.out.println(Arrays.asList(PetName).indexOf(name));
				System.out.println(NickName[Arrays.asList(PetName).indexOf(name)]);
				b = true;
			}
		}
		if (!b) {
			System.out.println("등록된 자료가 없습니다.");
		}

	}
}
