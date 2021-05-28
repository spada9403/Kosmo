package com.osh.m5d28_Equals_Exam;

class MyDate {
	int day;
	int month;
	int year;
	
	public MyDate(int day, int month, int year) {
		this.day =  day;
		this.month = month;
		this.year = year;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MyDate) {
			MyDate m = (MyDate)obj;
			if(this.day == m.day && this.month == m.month && this.year == m.year)
				return true;
			else
				return false;
		}else
			return false;
	}
	@Override
	public int hashCode() {
		int hash = Integer.parseInt(Integer.toString(this.day) + Integer.toString(this.month) + Integer.toString(this.year));
		return hash;
	}
}

public class MyDateTest {

	public static void main(String[] args) {
		MyDate date1 = new MyDate(9, 18, 2004);
		MyDate date2 = new MyDate(9, 18, 2004);
		System.out.println(date1.equals(date2));
		
		System.out.println(date1.hashCode());
		System.out.println(date2.hashCode());
	}

}
