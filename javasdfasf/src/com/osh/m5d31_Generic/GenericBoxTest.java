package com.osh.m5d31_Generic;

public class GenericBoxTest {

	public static void main(String[] args) {
		
		
		// 일반 클래스
		Box box = new Box();
		box.set("안녕");
		box.set(new Integer(100) );
		int i = (int)box.get();
		
		// 제네릭 클래스
		Box2<String> box2 = new Box2();
		box2.set("안녕");
		String str = box2.get();

	}

}
class Box {
	private Object obj;
	public void set(Object o) {
		this.obj = o;
	}
	public Object get() {
		return this.obj;
	}
}

class Box2<String>{
	private String str;
	public void set(String s) {
		this.str = s;
	}
	public String get() {
		return this.str;
	}
}