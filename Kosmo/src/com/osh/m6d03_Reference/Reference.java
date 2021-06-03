package com.osh.m6d03_Reference;

public class Reference {
	
	public void copyByReference(String str1, String str2) {
		str1 = "ㅋㅋㅋ";
		str2 = "ㅋㅋㅋㅋ";
		System.out.println("Method str1:"+str1+" str2 = "+str2);
	}
	
	public void copyByvalue(int i, boolean b) { // main메소드의 num, b의 참조값(레퍼런스)가 아닌 참조값이 가르키는 heap메모리의 값을 직접적으로 가져온다. Main의 num, b는 값이 바뀌지 않음.
		i = 100;
		b = false;
		System.out.println("Method i:"+i+" b = "+b);
	}
	public void copyByReference(String[] str) { // Main의 str배열이 가르키고 있는 heap메모리의 변수들의 값을 직접적으로 바꾼다.(Main 에서 str배열의 값도 같이 바뀜.)
		str[0] = "ㅋㅋㅋ";
		str[1] = "ㅋㅋㅋㅋ";
		System.out.println("Method str[0]:"+str[0]+" str[1] = "+str[1]);
	}

	public static void main(String[] args) {
		//기본 자료형
		int num = 10;
		boolean b = true;
		
		// 객체자료형
		int[] a = new int[10];
		String str1 = "홍길동";
		String str2 = new String("고길동"); // String 자료형은 객체와 기본자료형의 특성을 모두 가지고 있다. 그래서 new 연산자를 사용가능하지만, 레퍼런스가 아닌 변수값을 넘긴다.
		String[] str = {"홍길동","고길동"};
		
		Reference c = new Reference();
		c.copyByvalue(num,b); // 기본자료형은 레퍼런스 값이 아닌 변수가 가르키는 값 자체를 넘긴다.
		System.out.println("Main i:"+num+" b = "+b);
		c.copyByReference(str);// Stack메모리에 있는 str배열이 가르키고있는 heap메모리 의 주소를 넘겨준다.
		System.out.println("Main str[0]:"+str[0]+" str[1] = "+str[1]);	
		c.copyByReference(str1, str2); // String str1, str2는 레퍼런스를 주는것이 아니라 값 자체를 넘겨준다.
		System.out.println("Main str1:"+str1+" str2 = "+str2);
		
		// 객체 Object -> 코드상의 객체(클래스, 배열 등), 설계상의 객체
		// 인스턴스 -> 메모리 상의 객체.
		// 멤버 -> 객체의 (속성//필드, 메서드) 를 통칭 멤버라고함.
		// 참조변수 -> 어떠한 객체의 참조값을 가지고있는 식별자. 현재 파일에서 str이 참조변수이다. str[] 의 인스턴스를 가르키는 값을 담고있다.
		// 참조 값 -> 객체의 인스턴스를 가르키는 hashCode(메모리주소값)
	}

}
