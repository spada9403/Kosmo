package com.osh.m6d01_InnerClass;
// 데이터 베이스 접속 가정하에 실습.
public class ExInnerClassDb {

	public void retrieve(String table) {
		//db table 에서 data row fetch.
		// 제목, 저자, 청구번호 가져온다고가정.
		
		
		class Book {
			// retrieve 안에서만 사용한다면 그대로 쓰는데, 다른 메서드에서도 사용해야 한다면 일반 내부 클래스로 만드는것이 유리.
			String author;
			String title;
			String num;
			
			public Book(String a, String t, String n) {
				this.author = a;
				this.title = t;
				this.num = n;
			}
		}
		
		// String[] result = Db.fetch(table); 제목, 저자, 청구번호를 String 배열로 가져옴.
		String[] result = {"자바","고스링","ㄱ1000"};
		Book book = new Book(result[0],result[1],result[2]);
		
		
	}
	
	public static void main(String[] args) {
		
	}

}
