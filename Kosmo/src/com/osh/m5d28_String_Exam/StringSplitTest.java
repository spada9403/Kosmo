package com.osh.m5d28_String_Exam;

import java.util.StringTokenizer;

public class StringSplitTest {

	public static void main(String[] args) {

		String str = "Java Programming is funny things!";
		//String str = "Java\\Programming\\is\\funny\\things!";
		
		// split() 메서드는 delemiter 를 매개변수로 받아  문자열을 나눠서 배열로 반환한다.
		// 간단한 문장 같은 경우는 괜찮지만 문장이 길어지거나 복잡해지면 효율이 떨어진다.
		String[] result = str.split( " " );
		
		for(String s : result) {
			System.out.println(s);
		}
		
		// split()상위호환. 많이들 쓴다 합니다.
		// StringTokenizer class
		
		StringTokenizer st = new StringTokenizer(str);
			// 자동으로 delimiter를 찾아 나눠준다 ㅎㄷㄷ;
			// 수동으로 정해줄수도 있다.
		while(st.hasMoreTokens()) { // hasMoreTokens() 는 매개변수로 건네준 문자열중 다음 문자열이 아직 있으면 true를 반환하고, 더 이상 문자열이 없다면 false를 반환 한다.
			System.out.println(st.nextToken()); // 나눠진 문자열 출력
		}
		
	}

}
