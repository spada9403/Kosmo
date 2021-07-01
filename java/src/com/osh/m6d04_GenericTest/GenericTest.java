package com.osh.m6d04_GenericTest;

public class GenericTest {
	public void print() {
		ThreeD printer = new ThreeD();
		Plastic p = new Plastic();
		printer.setMaterial(p);
		Object m = printer.getMaterial();
		
		Plastic pp = (Plastic)m;
		// Generic class 이용
		GenericPrinter<Powder> powderPrinter = new GenericPrinter();
		
		powderPrinter.setMaterial(new Powder());
		Powder pp2 = powderPrinter.getMaterial();
		
	}
	
}

class GenericPrinter<T> {
	
	private T material;
	
	void setMaterial(T o) {
		this.material = o;
	}
	T getMaterial() {return this.material;};
}

class ThreeD {
	private Object setMaterial;

	void setMaterial(Object o) {
		this.setMaterial = o;
	}
	Object getMaterial() {return this.setMaterial;};
}

class Plastic{
}

class Powder {
	
}
