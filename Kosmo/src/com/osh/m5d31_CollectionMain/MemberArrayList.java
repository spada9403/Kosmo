package com.osh.m5d31_CollectionMain;

import java.util.ArrayList;

import com.osh.m5d31_Collection.Member;

public class MemberArrayList {

	private ArrayList<Member> arrayList;
	
	public MemberArrayList() {
		arrayList = new ArrayList<>();
	}
	
	public void addMember(Member m) {
		arrayList.add(m);
	}
	public boolean removeMember(int memberId) {
		for(int i = 0; i < arrayList.size(); i++) {
			Member member = arrayList.get(i);
			int tempId = member.getMamberId();
			if(tempId == memberId) {
				arrayList.remove(i);
				return true;
			} else
				return false;
		}
		return true;
	}
	public void showAllMembers() {
		for(Member m : arrayList) {
			System.out.println(m);
		}
		System.out.println();
	}

}
