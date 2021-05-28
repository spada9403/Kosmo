package com.osh.m5d28_String_Exam;

public class StringConcatTest {

	public static void main(String[] args) {
		
		//start Time
		long start = System.currentTimeMillis();
		
		String str1 = new String("java");
		String str2 = "Programing";
		String result = str1;
		
		int sum = 0;
		for(int i = 0; i <= 1000; i ++) {
			result = result.concat(" ").concat(str2);
		}
		
		
		System.out.println(result);
		// 끝 시점 시간.
		long end = System.currentTimeMillis();
		
		System.out.println("----------Concatenating------------");
		System.out.println("합: " + sum);
		System.out.println("시간: "+ (end - start)/1000);
		
		start = System.currentTimeMillis();

		for(int i = 0; i <= 1000; i ++) {
			result += " " + str2;
		}
		
		
		System.out.println(result);
		// 끝 시점 시간.
		end = System.currentTimeMillis();
		
		System.out.println("----------Concatenating------------");
		System.out.println("시간: "+ (end - start)/1000);
		
		
	}

}
