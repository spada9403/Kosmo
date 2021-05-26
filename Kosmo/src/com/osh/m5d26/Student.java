package com.osh.m5d26;

public class Student {
	// Source 메뉴의 Generate getters and seters 를 사용하면
	// 자신이 지정한 멤버 변수의 get/set 메서드를 자동으로 만들어 준다.

	private String studentName;
	private int grade;
	
	protected String address;
	
	int studentID;
	
	public int score;

	public String showStudentInfo() {
		String info = studentName + "/" + studentID + "/" + address;
		return info;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getScore() {
		return score;
	}

	public void println() {
		String info = studentName + "/" + studentID + "/" + address;
		System.out.println(info);
	}

	public String setScore(int score) {
		this.score = score;
		String info = showStudentInfo();
		return info + "/score = " + this.score;
	}

	public void setScore2(int score) {
		this.score = score;
	}
}
