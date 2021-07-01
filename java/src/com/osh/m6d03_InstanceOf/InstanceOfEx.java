package com.osh.m6d03_InstanceOf;

import com.osh.m6d03_inheritance.Phone;
import com.osh.m6d03_inheritance.VideoPhone;

public class InstanceOfEx {

	public static void main(String[] args) {
		Phone phone1 = new VideoPhone(); // 형태는 VideoPhone이지만 자료형이 Phone 이기때문에 VideoPhone 메소드/변수 사용 불가. 다운캐스팅 후 사용.
		if(phone1 instanceof VideoPhone) {
			System.out.println("1");
		}
		if(phone1 instanceof Phone) System.out.println("2");
		
		Phone phone2 = new Phone(); // 형태와 자료형 모두 Phone 이기 때문에 다운캐스팅으로 해도 VideoPhone 의 변수/메소드 사용 불가
		if(phone2 instanceof VideoPhone) {
			System.out.println("3");
		}
		if(phone2 instanceof Phone) System.out.println("4");
		
		VideoPhone phone3 = new VideoPhone();
		if(phone3 instanceof Phone) {
			System.out.println(5);
		}
		if(phone3 instanceof VideoPhone) {
			System.out.println("6");
		}
	}

}
