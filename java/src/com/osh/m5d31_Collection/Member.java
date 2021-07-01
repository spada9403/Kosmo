package com.osh.m5d31_Collection;

public class Member {

	private int memberId;
	private String memberName;
	
	public Member(int id, String name) {
		this.memberId = id;
		this.memberName = name;
	}

	public int getMamberId() {
		return memberId;
	}

	public void setMamberId(int mamberId) {
		this.memberId = mamberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		return memberName + " 회원님 아이디는 " + memberId + "입니다.";
	}
	@Override
	public int hashCode() {
		return memberId;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member)obj;
			if(this.memberId == member.memberId) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}
