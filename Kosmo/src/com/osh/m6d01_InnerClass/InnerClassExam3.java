package com.osh.m6d01_InnerClass;

import java.util.Date;

// local(method) Inner Class
// bonus LocalInnerTest
public class InnerClassExam3 {

	public void printStatus() {

		class DateFormat {

			private Date date;

			public DateFormat(Date date) {
				this.date = date;
			}

			public String getDateFormat() {
				return date.toString();
			}
		}

		// Class 앞에 쓰면 DateFormat이 선언 되기전에 사용하려고 하는것이기때문에 오류가 난다.
		// 반드시 선언 후에 사용할 것.
		 DateFormat format = new DateFormat(new Date());
		 System.out.println("The Date : " + format.getDateFormat());
		 
	}

	public static void main(String[] args) {
		InnerClassExam3 inner = new InnerClassExam3();
		inner.printStatus();
	}

}
