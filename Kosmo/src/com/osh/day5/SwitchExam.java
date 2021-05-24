package com.osh.day5;

public class SwitchExam {

	public static void main(String[] args) {
		int ranking = 3;
		char medalColor;
		
		switch (ranking) { // 조건식에 정수 뿐만이 아닌 문자열도 사용 가능하다.
		case 1: medalColor = 'G'; // break를 쓰지 않으면 모든 case코드들이 실행된다.
			break;
		case 2: medalColor = 'S';
			break;
		case 3: medalColor = 'B';
			break;
		default:
				medalColor = 'A';
		}
		System.out.println(ranking + "등 메달의 색깔은 " + medalColor + "입니다.");
	}

}
