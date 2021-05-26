package com.osh.m5d26_ClassAccess2;

class C { // Default = 같은 패키지 안에서만 접근 가능.
	D d = new D(); // 같은 패키지 안에 있기때문에 Default 클래스라도 쓸수있다.
	
	public void k()	{
		B b = new B();
		b.n = 7; // n과 g메서드는 protected 이여서 같은 패키지인 C클래스에서 접근이 가능하다.
		b.g();
	}
	
}
