package com.osh.m5d31_ArrayClone;

import java.util.ArrayList;

public class ArrayListMain {

	public static void main(String[] args) {
//		ArrayList<Book> library = new ArrayList<Book>();
		ArrayList<Book> library = new ArrayList<>(); // - > ArrayList 는 순서유지, 중복가능하다. 기본 배열크기 10이 지정되어있고, 10을 넘어가면 새로운 큰 용량의 배열을 만들고 기존 항목을 복사한다.
		
		Book b1 = new Book("태백산맥");
		library.add(b1);
		library.add(new Book("차령산맥"));
		library.add(new Book("한라산맥"));
		library.add(new Book("백두산맥"));
		library.add(new Book("구로산맥"));
		
		System.out.println("Books size: " + library.size());
		
		//library.remove(2);
		library.remove(b1);//new Book("태백산맥"));
		
		System.out.println("Books size: " + library.size());
		System.out.println("Books size: " + library.get(2).name);
		System.out.println("Books size: " + library.get(3).name);
		
		for(Book b : library) {
			System.out.println(b.name);
		}
		
	}

}
