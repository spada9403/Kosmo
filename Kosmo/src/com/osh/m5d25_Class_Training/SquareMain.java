package com.osh.m5d25_Class_Training;

public class SquareMain {

	public static void main(String[] args) {
		Square s = new Square();
		s.printSquare();
		Square s1 = new Square("종이박스");
		s1.printSquare();
		Square s2 = new Square(45, 45.5);
		s2.printSquare();
		Square s3 = new Square("Rectangle", 60, 30);
		s3.printSquare();
	}

}
