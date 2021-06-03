package com.osh.m6d03_inheritance;

public class PhoneMain {

	public static void main(String[] args) {
		Phone phone1 = new Phone("전화", "레드", "111111");
		phone1.powerOn();
		phone1.ring();
		phone1.send();
		phone1.powerOff();
		
		VideoPhone phone2 = new VideoPhone("영상전화", "노랑", "111112");
		phone2.powerOn();
		phone2.ring();
		phone2.send();
		phone2.videoCall();
		phone2.powerOff();
		
	}

}
