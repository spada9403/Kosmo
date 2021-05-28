package com.osh.m5d28_String_Exam;

import java.util.Calendar;

public class StringFormatBonus_Calendar {

	public static void main(String[] args) {

		Calendar now = Calendar.getInstance(); // singletone 
		/*
		 * 원패턴 디자인(singletone)
		 * 프로그램 전체에서 단 하나의 인스턴스로만 사용하는 것을 원패턴 디자인 이라고 한다.
		 * Calendar 클래스는 원패턴 디자인이며, static 클래스로 자바 가상 머신이 시작될때 같이 시작하고,
		 * 생성자가 private이므로 추가 인스턴스를 생성하지 못한다.
		 */
		
		now.get(Calendar.DAY_OF_WEEK);
		now.get(Calendar.YEAR);
		now.get(Calendar.DAY_OF_MONTH);
		now.get(Calendar.DAY_OF_YEAR);
		
		
	}

}
