package com.osh.m6d04_InnerClass;

public class InnerClassTest {
	
	class InnerClass {
		String name;
		static final int a = 0;
		void info() {
			
		}
	}
	private int num = 10;
	private static int snum = 10;
	
	
	static class StaticInnerClass {
		int a = 0;
		static int i = 0;
		
		void info() {
			//num += 1;
			snum += 10;
		}
	}
	
	// 지역 내부 클래스 -> method
	public void local() {
		
		class Test {
			int a;
			String n;
		}
		
		Test t = new Test();
		
	}
	public Runnable getRunnable() {
		class MyRunnable implements Runnable{
			@Override
			public void run() {
			}
			
		}
		return new MyRunnable();
	}
	
	public int getint() {
		String a= "";
		String b = "cc";
		b = a;
		
		return 0;
	}
	
	Object o = new Object() {
		@Override
		public String toString() {
			return "----------";
		}
	};
	
	public Object getobj() {
		return new Object() {
			@Override
			public String toString() {
				return "----------";
			}
		};
	}
	
}
