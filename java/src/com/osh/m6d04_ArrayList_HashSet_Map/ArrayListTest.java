package com.osh.m6d04_ArrayList_HashSet_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.osh.m6d03_abstract.Player;

public class ArrayListTest {

	public static void main(String[] args) {

		Player[] p = new Player[10];

		ArrayList<Player> list = new ArrayList<Player>();
		ArrayList<Player> list2 = new ArrayList<>();

		list.add(new Player());
		list.add(new Player());
		list.add(new Player());

		list.get(0);
		list.get(1);

		list.remove(0);

		for (Player ppp : list) {

		}

		HashSet<String> hashset = new HashSet<>();

		hashset.add("홍길동");
		hashset.add("김길동");
		hashset.add("홍길동");
		hashset.add("김길동");
		hashset.add("고길동");
		hashset.add("김길동");
		hashset.add("고길동");

		System.out.println(hashset);

		Iterator<String> iter = hashset.iterator();

		while (iter.hasNext()) {
			String s = iter.next();

		}
		// key = value
		HashMap<String, Integer> map = new HashMap<>();
		map.put("홍길동", 1);
		map.put("홍길동", 2);
		map.put("홍길동", 3);
		map.put("고길동", 1);
		map.put("고길동", 2);
		map.put("고길동", 3);
		
		System.out.println(map);
		
		System.out.println(map.get("홍길동"));
		
		Set<String> ketSet = map.keySet();
		Iterator<String> KetIter = ketSet.iterator();
		
		while(KetIter.hasNext()) {
			String key = KetIter.next();
			Integer value = map.get(key);
			System.out.println(key + ": " + value);
		}

	}

}
