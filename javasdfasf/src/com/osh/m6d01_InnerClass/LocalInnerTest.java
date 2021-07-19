package com.osh.m6d01_InnerClass;
// 쓰레드? 지역 인터페이스? 실습
class Outer{
	int outNum = 100;
	static int sNum = 200;
	
	Runnable getRunnable(int i) {
		int num = 100;
		
		class MyRunnable implements Runnable {
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
		}
		// 원래는 MyRunnable은 메서드 안에서만 사용이 가능해서 리턴할수 없고, 외부에서 접근, 인스턴스를 못만들지만,
		// 상위 클래스 객체인 Runnable로 업캐스팅해서 내보내면 접근이가능해지고 객체가 살아남는다.
		// 이러한 역활을 하는것이 인터페이스 이다. Closer 현상
		return new MyRunnable(); // getRunnable은 Runnable을 리턴하기 떄문에 MyRunnable 을 Runnable로 업캐스팅해서 반환한다.
	}
}
public class LocalInnerTest {
	
	public static void main(String[] args) {
		Outer out = new Outer();
		Runnable runner = out.getRunnable(10); // getRunnable 호출이 끝나고 지역변수가모두 사라짐.
		runner.run(); // getRunnable 의 지역변수를 참조가된다. 지역 내부 클래스에서 사용된 지역 변수는 모두 상수로서 처리된다.
		
	}

}
