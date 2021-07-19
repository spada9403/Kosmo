package com.osh.day6;

public class Test {

	public static void main(String[] args) {

		// 리턴타입 메소드이름(파라미터)
		// String toString(asd fsdf sdfg)

		String str1 = new String("abc");
		String str2 = "abc";
		String str3 = "abc";

		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);

		str2 = "efg";

		System.out.println(str2);
		System.out.println(str3);

		// charAt(index)
		String str4;
		str4 = "하나둘셋";
		System.out.println(str4);

		// final char charAt(int);

		// dot operator : .
		System.out.println(str4.charAt(0));

		for (int i = 0; i < str4.length(); i++) {
			System.out.println(str4.charAt(i));
		}
		// String 은 객채이다. 배열이 아니다.
		// for(char ch: str4) {
		// System.out.println(ch);
		// }

		// equals(string)
		System.out.println(str4.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str3.equals("abc"));
		// 순서는 str1.equals("abc") 보다 "abc".equals(str1) 순서가 더 좋다. => null 포인트 익셉션 회피.

		// split

		String[] strs = "하 나 두 ㄹ ㅅ ㅔ 넷".split(" ");

		for (String s : strs) {
			System.out.println(s);
		}
		// substring
		System.out.println("하 나 두 ㄹ ㅅ ㅔ 넷".substring(2, 5));
	}

}
