package com.osh.m5d28_Clone_Exam;

public class Bonus_SystemMethodTest {

	public static void main(String[] args) { // static이 붙으면 별개의 메모리에 저장되어 프로그램이 끝날때까지 유지되고 new 연산자 없이도 사용이 가능하다.
		
		//동작하다가 프로그램을 끝낼때 사용하는 메서드.
//		System.exit(0);
		
		// getProperty()
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");

		System.out.println("OS" + osName);
		System.out.println("User" + userName);
		System.out.println( System.getProperty("user.dir"));
		System.out.println( System.getProperty("java.class.path"));
		
		//모든 Property
		System.getProperties().list(System.out);
		//getEnv()
		System.out.println(System.getenv("PATH"));
		
//		long start = System.nanoTime();
//		
//		int sum = 0;
//		for(int i = 0; i <= 100000000; i ++) {
//			sum += 1;
//		}
//		
//		// 끝 시점 시간.
//		long end = System.nanoTime();
//		
//		System.out.println("합: " + sum);
//		System.out.println("시간: "+ (end - start));
	}

}
