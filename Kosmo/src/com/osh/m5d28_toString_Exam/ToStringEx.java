package com.osh.m5d28_toString_Exam;

import com.osh.m5d28_interface_Exam.*;

class Book {
	
	int bookNumber;
	String bookTitle;
	
	Book(int bookNumber, String bookTitle){
		this.bookNumber = bookNumber;
		this.bookTitle = bookTitle;
		
	}
	@Override
	public String toString() {
		
		Class c = getClass();
		c.getName();
		
		return getClass().getName() + ":" + 
		 Integer.toHexString(hashCode()) + ":" + bookTitle + "," + bookNumber;
	}
}

public class ToStringEx {
	
	
	public static void main(String[] args) {
		
		Book book1 = new Book(200,"개미");
		
		System.out.println(book1); // 자동으로 toString() 을 호출한다.
		System.out.println(book1.toString());
		
		//toString() 이 재정의 된 클래스
		
		String str = new String("알고리즘");
		Integer i1 = new Integer(1000); //@Deprecated 메서드. 재사용 하지 않는다는 의미이다. 생성자 메소드에도 사용이 가능. 
		System.out.println(str);
		System.out.println(i1);
		
		
		Drawable d= new Drawable() {
			
			@Override
			public void draw(int color) {
				// TODO Auto-generated method stub
				
			}
		};
		DrawableMain dm = new DrawableMain();
		
		System.out.println(d); // 클래스가 ToStringEx가 나오는데, 인터페이스 Drawable이 ToStringEx 클래스에서 만들어졌기때문.  $1 이붙어있는데 인터페이여서 클래스 이름이 없으므로(Anonymus) 1로 표기한것.
		System.out.println(dm);
		
	}

}
