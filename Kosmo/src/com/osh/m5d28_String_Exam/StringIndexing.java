package com.osh.m5d28_String_Exam;

public class StringIndexing {

	public static void main(String[] args) {
		
		String str = "Java Programming";
		
		System.out.println(str.indexOf("J"));
		System.out.println(str.indexOf('P'));
		System.out.println(str.indexOf("gram"));
		
		//자르기
		System.out.println( str.substring(0,str.indexOf( "gram" )));
		
		System.out.println(str.lastIndexOf( "n" )); // indexof와 값은 같지만. LastIndexOf는 문자열 뒤에서부터 찾는다.
		
		System.out.println(str.startsWith( "java" ));
		System.out.println(str.startsWith( "Java" ));
		
		// trim
		// Scanner -> 
		String str1 = "            HaHa";
		String str2 = "       hohoho                ";
		
		
		System.out.println(str1);
		System.out.println(str1.trim());
		System.out.println(str2.trim());
		
	}

}
