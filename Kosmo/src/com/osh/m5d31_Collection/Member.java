package com.osh.m5d31_Collection;

public class Member {

	private int mamberId;
	private String memberName;
	
	public Member(int id, String name) {
		this.mamberId = id;
		this.memberName = name;
	}

	public int getMamberId() {
		return mamberId;
	}

	public void setMamberId(int mamberId) {
		this.mamberId = mamberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		return memberName = " 회원님 아이디는 " + mamberId + "입니다.";
	}
	
}
