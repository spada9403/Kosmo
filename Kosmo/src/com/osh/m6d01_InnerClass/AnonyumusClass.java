package com.osh.m6d01_InnerClass;
// 익명 내부 클래스
public class AnonyumusClass {
	public static void main(String[] args) {
		AnonyumusClass ano = new AnonyumusClass();
		System.out.println(ano.getName().toString());
		// 결과에 클래스이름이 없고 $1 이라고 표시된다!
	}
	
	public Object getName() {
		return new Object() { // 클래스 이름이 없지만 Object이다. 클래스 이름이 없으므로 익명 내부 클래스라고 한다.
			// 객체화 해서 리턴하고 싶은때에는 Object 상속을 받은 클래스를 따로 만들어서 리턴해야한다.
			@Override
			public String toString() {
				return this.getClass().getName();
			}
		}; // 세미콜론 필수!!!
	}
	
}
