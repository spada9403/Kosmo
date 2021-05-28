package com.osh.m5d28_String_Exam;

import java.util.Calendar;

public class StringFormatBonus_Calendar {

	public static void main(String[] args) {

		Calendar now = Calendar.getInstance(); // singletone
		now.get(Calendar.DAY_OF_WEEK);
		now.get(Calendar.YEAR);
		now.get(Calendar.DAY_OF_MONTH);
		now.get(Calendar.DAY_OF_YEAR);
		
		
	}

}
