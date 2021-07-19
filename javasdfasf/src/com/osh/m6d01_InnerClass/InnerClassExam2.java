package com.osh.m6d01_InnerClass;
// static Inner Class
public class InnerClassExam2 {
	
	int num = 20;
	static int sum = 20;
	
	static class InnerClass {
		static String keyword = "STATIC INNER";
		
		public void info() {
			// num += 10; static 클래스에서 static이 아닌 변수를 사용하려고 하면 에러가 난다. (Main 메소드에서 외부 클래스의 변수를 그냥 사용하려 할때와 같다) 
			System.out.println("Inner.info()");
		}
		public static void printName() { // static 정적 변수/ 메서드만 사용 가능하다.
			System.out.println("Inner.printName()");
		}
	}

	public static void main(String[] args) {

		InnerClass inner = new InnerClassExam2.InnerClass(); // 외부 클래스 인스턴스를 만들지 않았다!!
		System.out.println(InnerClass.keyword); // static이기 때문에 바로 접근이 가능하다.
		
		inner.info();
		InnerClass.printName(); // 메소드도 똑같이 가능.
		
	}

}
