package com.osh.m5d28_String_Exam;

public class StringIndexing {

	public static void main(String[] args) {
		
		String str = "Java Programming";
		// indexOf String 문자열이나 동적배열에서 매개변수로 받은 인자가 어느 인덱스부터 시작하는지 혹은 존재하는데 검색해 해당 인덱스를 리턴해준다. 
		System.out.println(str.indexOf("J"));
		System.out.println(str.indexOf('P'));
		System.out.println(str.indexOf("gram"));
		
		//자르기
		// substring은 Start index, end index 등을 매개변수로 해당 인덱스 구간을 잘라내서 리턴해준다.
		System.out.println( str.substring(0,str.indexOf( "gram" )));// 0번째 인덱스부터 "gram" 의 시작 인덱스 까지 구간을 잘라낸다.
		
		System.out.println(str.lastIndexOf( "n" )); // indexof와 값은 같지만. LastIndexOf는 문자열 뒤에서부터 찾는다.
		
		System.out.println(str.startsWith( "java" )); // 문자열이 시작할때 매개변수로 받은 문자열이 포함되는지 체크하여 boolean 값을 반환.
		System.out.println(str.startsWith( "Java" ));
		
		// trim -> 문자열 내에 모든 공백을 제거한다.
		// Scanner -> 
		String str1 = "            HaHa";
		String str2 = "       hohoho                ";
		
		
		System.out.println(str1);
		System.out.println(str1.trim());
		System.out.println(str2.trim());
		
	}

}
