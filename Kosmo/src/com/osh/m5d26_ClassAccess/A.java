package com.osh.m5d26_ClassAccess;

import com.osh.m5d26_ClassAccess2.B;
// import com.osh.m5d26_ClassAccess2.C; is Not Visible

class A {
	B b = new B();
	
	// C c = new C(); is Not Visible C클래스를 사용하려면 C클래스의 접근제한자를 public으로 하는 방법밖에 없다.
	
	// b.n = 3; // n은 protected 이기 때문에 접근 불가
	// b.g();
	
}
