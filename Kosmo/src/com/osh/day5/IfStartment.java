package com.osh.day5;

public class IfStartment {

	public static void main(String[] args) {
		
		int age = 10;
		// 조건 1
		if(age >= 8) {
			System.out.println("8888");
		} else {
			System.out.println(8);
		}
		//복합 조건
		int age2 = 10;
		if((age>=8)&&(age2>10)) {
			System.out.println(8888);
		} else {
			System.out.println(8);
		}
		// 보통 if만 쓰지 않고 else-if else 를 같이쓴다.
		int score = 70;
		
		if(score >=70) {
			System.out.println("합격");
		} else if(score >= 50){ // score 가 70 보다 작을때 실행. 
			System.out.println("재수강");
		} else {// if문 부터 차례대로 조건을 비교하고 조건이 맞지않는 모든 경우 실행.
			System.out.println("불합격");
		}
		//문제
		
		int age1 = 7;
		int charge = 0;
		
		if (age1 < 8) {
			System.out.println("취학 전 아동입니다.");
		} else if(age1 < 14){ // else if 말고 그냥 if를 쓰면 조건을 다시 비교한다. age1에 7를 넣고 전부 if로 바꿔보면 전부다 출력되는것을 볼 수 있다.
			charge = 2000;
			System.out.println("초등학생입니다.");
		} else if (age1 < 20) {
			charge = 2500;
			System.out.println("중,고등학생입니다.");
		} else {
			charge = 3000;
			System.out.println("일반인입니다.");
		}
		System.out.println("입장료는 " + charge + "원입니다.");
		
	}

}
