package com.osh.day5_Homework;

import java.util.Scanner;

public class Homework3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String weight = sc.next();
			if(weight.contains("q")) {
				break;
			} else if(Integer.parseInt(weight)==-1){
				break;
			} else {
				int height = sc.nextInt();
				boolean result = (Integer.parseInt(weight)+100-height) > 0 ? true : false;
				if(result) {
					System.out.println("비만수치 비만");
				} else {
					System.out.println("비만수치 정상");
				}
			}
		}
	}

}
