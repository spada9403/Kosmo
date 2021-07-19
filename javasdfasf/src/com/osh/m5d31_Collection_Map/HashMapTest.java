package com.osh.m5d31_Collection_Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<String, Integer>(); // <> 연산에서 , 로 받는 타입을 여러개 지정할수 있다.
		// map 은 key 와 value 로 구성됨. 키와 값은 모두 객체. 키는 중복될수 없다. 값은 가능. 보통 hashMap을 많이 사용.
		map.put("홍길동", 1); // 순서와 관계가 없다.
		map.put("고길동", 2);
		map.put("이동형", 3);
		map.put("자라섬", 4);
		
		Iterator<String> ir =  map.keySet().iterator();
		while(ir.hasNext()) {
			String key = ir.next();
			Integer v = map.get(key);
			System.out.println(key + " : " + v);
		}
		
		
	}

}
