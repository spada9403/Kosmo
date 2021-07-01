package com.osh.m5d31_CollectionMain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.osh.m5d31_Collection.Member;

public class ArrayAsListTest {

	public static void main(String[] args) {

		//서초구, 구로구, 강성구
		List<String> list = java.util.Arrays.asList("서초구","구로구", "강서구"); // ArrayList 하고 같다.
		List<Member> list1 = Arrays.asList(new Member(1,"홍길동"),
				new Member(2,"이순신"));
		
		for(String str : list) {
			System.out.println(str);
		}
		Iterator<Member> it = list1.iterator();
		while(it.hasNext()) {
			Member m =it.next();
			System.out.println(m.getMemberName());
		}
	}

}
