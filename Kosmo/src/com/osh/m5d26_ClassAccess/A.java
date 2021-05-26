package com.osh.m5d26_ClassAccess;

import com.osh.m5d26_ClassAccess2.B;
// import com.osh.m5d26_ClassAccess2.C; is Not Visible
// private >> 패키지 / 상속과 관계없이 절대 직접 사용불가.
// public >> 패키지 / 상속과 상관없이 어디서든 직접 사용 가능.
// protected >> 같은패키지, 상속받은클래스 에서만 사용 가능.
// default >> 같은 패키지 안에서만 접근가능. 다른패키지에있는 상속클래스도 사용 불가능.

class A {
	B b = new B();
	
	// C c = new C(); is Not Visible C클래스를 사용하려면 C클래스의 접근제한자를 public으로 하는 방법밖에 없다.
	
	// b.n = 3; // n은 protected 이기 때문에 접근 불가
	// b.g();
	// b.a; a멤버변수는 public 이지만 클래스가 default이므로 다른 패키지에 있는 A클래스가 사용할수 없다.
	
}
