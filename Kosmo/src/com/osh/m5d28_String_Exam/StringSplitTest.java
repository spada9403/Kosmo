package com.osh.m5d28_String_Exam;

import java.util.StringTokenizer;

public class StringSplitTest {

	public static void main(String[] args) {

		String str = "Java Programming is funny things!";
		//String str = "Java\\Programming\\is\\funny\\things!";
		
		String[] result = str.split( " " );
		
		for(String s : result) {
			System.out.println(s);
		}
		
		// StringTokenizer class
		
		StringTokenizer st = new StringTokenizer(str);

		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
	}

}
