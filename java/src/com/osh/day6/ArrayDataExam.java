package com.osh.day6;

import java.util.Scanner;

public class ArrayDataExam {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		/*
		 * 
		 * String[] intArray = new String[10]; String str = sc.nextLine();
		 * 
		 * intArray = str.split(",");
		 * 
		 * int most = 0;
		 * 
		 * for(int i = 0; i < (intArray.length-1); i++) { most =
		 * Integer.parseInt(intArray[i]) > Integer.parseInt(intArray[i+1]) ?
		 * Integer.parseInt(intArray[i]) : Integer.parseInt(intArray[i+1]); }
		 * System.out.println(most);
		 * 
		 * 
		 */
		// 문제2 위에 값 에 짝수번째 값들의 합과 평균 구하기. while문 쓰기.
		/*
		 * int index = 0; int sum = 0; int count = 0; while(true) { if(index == 0 ||
		 * index % 2 == 0) { sum += Integer.parseInt(intArray[index]); count++; }
		 * index++; if(index == intArray.length) { break; } } System.out.println(sum);
		 * System.out.println(sum/count);
		 */
		/*
		 * String str2 = sc.nextLine(); String[] strArray = str2.split(" "); String[]
		 * strArray2 = new String[strArray.length]; int index = 0; for(int
		 * i=(strArray.length-1); i >= 0 ;i--) { strArray2[index] = strArray[i];
		 * index++; } for(String s:strArray2) { System.out.println(s); }
		 */
		/*
		 * int[] intArray = new int[100];
		 * 
		 * for(int i = 0; i < intArray.length ; i++) { intArray[i] = sc.nextInt();
		 * if(intArray[i] == -1) { if(i < 3) { for(int j =0; j <= i-1; j++) {
		 * System.out.println(intArray[j]); } } else {
		 * System.out.println(intArray[i-3]); System.out.println(intArray[i-2]);
		 * System.out.println(intArray[i-1]); } break; } }
		 */
		/*
		 * char[] charArray = new char[] {'P','R','O','G','R','A','M','M','I','N','G'};
		 * 
		 * char ch = sc.next().charAt(0);
		 * 
		 * boolean bool = false;
		 * 
		 * for(int count = 0; count < charArray.length; count++ ) { if(charArray[count]
		 * == ch) { System.out.println(count); bool = true; } } if(!bool) {
		 * System.out.println("None"); }
		 */
		/*
		 * double[] classAvg = new double[] {85.6,79.5,83.1,80.0,78.2,75.0};
		 * 
		 * int first = sc.nextInt(); int second = sc.nextInt();
		 * 
		 * System.out.println((classAvg[first-1]+classAvg[second-1]));
		 */
	}

}
