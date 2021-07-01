package com.osh.m5d27_abstract;

public class ComputerMain {

	public static void main(String[] args) {

		//Computer c1 = new Computer(); // Computer 클래스 인식 못함
		Computer c2 = new Desktop();
		c2.display();
		c2.typing();
		c2.print();
		
	}

}
