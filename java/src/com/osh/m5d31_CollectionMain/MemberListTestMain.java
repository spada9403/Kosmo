package com.osh.m5d31_CollectionMain;

import com.osh.m5d31_Collection.Member;

public class MemberListTestMain {
	public static void main(String[] args) {
		MemberArrayList memberArrayList = new MemberArrayList();

		Member memberLee = new Member(1001, "이지원");
		Member memberSon = new Member(1002, "손민국");
		Member memberPark = new Member(1003, "박서훤");
		Member memberHong = new Member(1004, "홍길동");

		memberArrayList.addMember(memberLee);
		memberArrayList.addMember(memberSon);
		memberArrayList.addMember(memberPark);
		memberArrayList.addMember(memberHong);

		memberArrayList.showAllMembers();

		memberArrayList.removeMember(memberHong.getMamberId());
		memberArrayList.showAllMembers();

		Member member = new Member(1004, "동동동");
		memberArrayList.insertMember(member, 2);
		memberArrayList.showAllMembers();
	}
}
