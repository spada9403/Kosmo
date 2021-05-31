package com.osh.m5d31_ArrayClone;

public class ArrayTest {

	public static void main(String[] args) {
		int[] array1 = { 10, 20, 30, 40, 50 };
		int[] array2 = { 1, 2, 3, 4, 5 };

		try {
			System.arraycopy(array1, 0, array2, 3, 2);
			System.arraycopy(array1, 0, array2, 0, array1.length);
			
			for (int i : array2) {
				System.out.println(i);
			}
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("아 안된다고 ㅋㅋ");
		}
		System.out.println("=========얕은 복사============");
		Book[] book1 = new Book[3];
		Book[] book2 = new Book[3];
		book1[0] = new Book("태백산맥");
		book1[1] = new Book("차령산맥");
		book1[2] = new Book("계백산맥");
		
		System.arraycopy(book1, 0, book2, 0, book2.length);
		book1[0].name = "zzzz"; // book1[0]을 바꿧는데 book2[0]도 같이 바뀜. 같은 인스턴스 값을 가지고 있기때문. (얕은복사)
		
		for(Book n:book2) {
			System.out.println(n.name);
		}
		// 깊은 복사 !
		System.out.println("=========깊은 복사============");
		book1[0] = new Book("한라산맥"); // 새로운 인스턴스를 만들어주면 다른 참조값을 가지기 때문에 따로 관리할수있따.(book2[0]은 변경 안됨.
		for(Book n:book2) {
			System.out.println(n.name);
		}
		for(Book n:book1) {
			System.out.println(n.name);
		}

	}

}

