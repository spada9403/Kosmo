package com.osh.m6d01_InnerClass;


// Outer Class 외부 클래스
public class InnerLastTest {
	// 익명클래스는 이런식으로도 쓰인다.
	Object o = new Object() {
		@Override
		public String toString() {
			return super.toString();
		}
	};

	public InnerLastTest() {
	}
	
	// 익명 클래스 // 메소드 안에서만 쓰는것이 아니라 클래스 안이라던가 여러군데에서 많이 쓰인다.
	
	Object method2() {
		return new Object(){
			// 익명 클래스는 상속받는것과 비슷하다.
			// 상속 이므로 오버라이드를 할 수 있다.
			static final int a = 100;
			
			@Override
			public String toString() {
				return this.getClass().getName();
			}
		};
	}
	
	Runnable method3() {
		return new Runnable() {
			
			@Override
			public void run() {
				System.out.println("RUN!!!");
			}
		};
	}
	
	
	// 메소드 내부 클래스
	void method() {
		
		class abc {
			int a = 10;
			//static int b = 100; static 사용 불가능.
			
			public abc() {
				// TODO Auto-generated constructor stub
			}
		}
		
		abc ABC = new abc();
		ABC.a = 1000;
	}
	
	// 인스턴스 내부 클래스
	public class InstanceInner {
		
		int abc;
		static final int a = 10;
		
		public InstanceInner(){
		}
		
		public void print() {
			abc = 1000;
			System.out.println(abc);
		}
	}
	
	// 정적 내부 클래스
	static class StaticInner {
		int abc;
		static int abcd = 100;
		
		public StaticInner() {
		}
		public void print() {
			System.out.println(abc);
			System.out.println(StaticInner.abcd);
		}
		static void info() {
			System.out.println(abcd); // static 변수/메소드만 사용가능.
		}
	}
	
}
