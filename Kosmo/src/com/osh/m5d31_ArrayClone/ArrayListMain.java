package com.osh.m5d31_ArrayClone;

import java.util.ArrayList;

public class ArrayListMain {

	public static void main(String[] args) {
//		ArrayList<Book> library = new ArrayList<Book>();
		ArrayList<Book> library = new ArrayList<>();
		
		library.add(new Book("태백산맥"));
		library.add(new Book("차령산맥"));
		library.add(new Book("한라산맥"));
		library.add(new Book("백두산맥"));
		library.add(new Book("구로산맥"));
		
		System.out.println("Books size: " + library.size());
		
		library.remove(2);
		
		System.out.println("Books size: " + library.size());
		System.out.println("Books size: " + library.get(2).name);
		System.out.println("Books size: " + library.get(3).name);
		
		for(Book b : library) {
			System.out.println(b.name);
		}
		
	}

}
