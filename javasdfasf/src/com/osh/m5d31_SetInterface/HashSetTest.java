package com.osh.m5d31_SetInterface;

import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		// set - > 수학의 집합에 비유. 하나의 null만 저장가능.

		HashSet<String> hashSet = new HashSet<String>(); // 정해진 순서가 없음, 중복을 허용하지 않음.
//		hashSet.add("임정순");
//		hashSet.add("박현정");
//		hashSet.add("홍연의");
//		hashSet.add("강감찬");
//		hashSet.add("강감찬");
//		
//		System.out.println(hashSet);
		
		// 새로운 인스턴스를 만들어도 중복이 안됨..
		hashSet.add(new String("임정순"));
		hashSet.add(new String("박현정"));
		hashSet.add(new String("홍연의"));
		hashSet.add(new String("강감찬"));
		hashSet.add(new String("강감찬"));
		
		System.out.println(hashSet);
		
	}

}
