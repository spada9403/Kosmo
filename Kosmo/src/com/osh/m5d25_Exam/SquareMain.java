package com.osh.m5d25_Exam;

public class SquareMain {

	public static void main(String[] args) {
		Square s = new Square();
		s.printSquare();
		System.out.println(s.Area());
		Square s1 = new Square("종이박스");
		System.out.println(s1.Area());
		s1.printSquare();
		Square s2 = new Square(45, 45.5);
		System.out.println(s2.Area());
		s2.printSquare();
		Square s3 = new Square("Rectangle", 60, 30);
		System.out.println(s3.Area());
		s3.printSquare();
	}

}
