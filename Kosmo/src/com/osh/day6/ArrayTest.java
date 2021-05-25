package com.osh.day6;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		String[] strArray = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		// 결과값이 같음.
		System.out.println(strArray.toString());
		System.out.println(strArray);

		for (int i = 0; i < strArray.length; i++) {
			int t = i * Integer.parseInt(strArray[i]);
			strArray[i] = t + "";
			System.out.println(strArray[i]);
		}
		strArray[5] = "Hello";

		// java.util.Arrays
		System.out.println(Arrays.toString(strArray));
	}
}
