package com.osh.m6d01_InnerClass;
// LocalInnerTest 파일을 익명 내부 클래스로 바꿔봄.
class Outer2{
	int outNum = 100;
	static int sNum = 200;
	
	Runnable getRunnable(int i) {
		int num = 100;
		
		return new Runnable() {
			int localNum = 10;
						
			@Override
			public void run() {
				// num = 200 ; 지역 변수는 상수로 바뀌므로 값을 변경할수 없다.
				// i = 100 ; 매개변수도 지역 변수처럼 상수로 바뀌므로 값을 변경할수 없다.
				System.out.println("i = " + i);
				System.out.println("num = " + num);
				System.out.println("localNum = " + localNum);
				System.out.println("outNum = " + outNum + "(외부 클래스 인스턴스 변수)");
				System.out.println("Outer.sNum = " + Outer.sNum + "(외부 클래스 정적 변수)");
			}
		};
	}
}

public class LocalInnerTest_Anonymus {
	
	public static void main(String[] args) {
		Outer2 out = new Outer2();
		Runnable runner = out.getRunnable(10); // getRunnable 호출이 끝나고 지역변수가모두 사라짐.
		runner.run(); // getRunnable 의 지역변수를 참조가된다. 지역 내부 클래스에서 사용된 지역 변수는 모두 상수로서 처리된다.
		
	}

}
