package com.osh.m6d01_InnerClass;
// Inner Class
public class InnerClassExam {

	private int outerHashCode;
	public String outerClassName;
	static boolean isuOter;
	
	InnerClassExam() {
		outerHashCode = System.identityHashCode(this);
		outerClassName = this.getClass().getName();
		isuOter = true;
	}
	class InnerClass {
		private int innerHashCode;
		public String innerClassName;
		// final 키워드 단독으로 선언할수없다.
		// final boolean isInner  반드시 초기값을 주어야한다.
		static final boolean isInner = true;
		
		public InnerClass(){
			innerHashCode = System.identityHashCode(this);
			innerClassName = this.getClass().getName();
		}
		
		public void printOutherInfo() {
			System.out.println("Outher Class HashCode: " + outerHashCode);
			System.out.println("Outher Class ClassName: " + outerClassName);
			System.out.println("Is it Outher Class: " + isuOter);
		}
		public void printInnerInfo() {
			System.out.println("Inner Class HashCode: " + innerHashCode);
			System.out.println("Inner Class ClassName: " + innerClassName);
			System.out.println("Is it Inner Class: " + isInner);
		}
		
	}
	
	public static void main(String[] args) {
		InnerClassExam outher = new InnerClassExam();
		InnerClassExam.InnerClass inner = outher.new InnerClass(); // 새로운 방식 ㄴㅇㄱ 
		
		System.out.println("=================InnerClass");
		inner.printInnerInfo();
		System.out.println("=================OutherClass");
		inner.printOutherInfo();
	}
	
}
