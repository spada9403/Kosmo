package com.osh.m5d27;

public class Exam_278P_Q4 {
	public String name;
	public String grade;
	public Exam_278P_Q4(String name) {
		//this.name = name 세미콜론 ; 안찍힘. 
	}
//}
// public class Enginner extends Exam_278P { 
//부모 클래스 Exam_278p 의 기본 생성자가 없기 때문에 super를 써서 constructor를 만들어 줘야함.
	private String skillset;
	public String getSkillSet() {
		return skillset;
	}
//	public void setSkillSet(String skillset) 코드블럭이 없음. 
//		this.skillSet = skillset; 선언한 멤버 변수의 대소문자 구별이 잘못됨. 
	
}
