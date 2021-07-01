package com.osh.m5d31_SetInterface;

import java.util.HashSet;
import java.util.Iterator;

import com.osh.m5d31_Collection.Member;

public class MemberHashSet {

	private HashSet<Member> hashSet; // hashCode() 와 Equals를 재정의 하여 사용하면 중복된 Member 자료를 자동으로 삭제해준다.

	public MemberHashSet() {
		hashSet = new HashSet<Member>();
	}

	public void addMember(Member member) {
		hashSet.add(member);
	}

	public boolean removeMember(int memberId) {
		Iterator<Member> ir = hashSet.iterator();

		while (ir.hasNext()) {
			Member member = ir.next();
			int tempId = member.getMamberId();
			if (tempId == memberId) {
				hashSet.remove(member);
				return true;
			}
		}
		System.out.println(memberId + "가 존재하지 않습니다");
		return false;
	}

	public void showAllMember() {
		for (Member member : hashSet) {
			System.out.println(member);
		}
		System.out.println();
	}

}
