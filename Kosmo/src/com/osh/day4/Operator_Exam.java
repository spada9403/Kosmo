package com.osh.day4;

public class Operator_Exam {

	public static void main(String[] args) {
		int mathScore = 90;
		int engScore = 70;

		int totalScore = mathScore + engScore;
		System.out.println(totalScore);

		double avgScore = totalScore / 3.0; // 3으로 나누면 int 형으로 계산이 되기 때문에 소수점 밑이 버려진다. .0을 붙여서 암묵적형변환으로 실수형으로 계산할것.
		System.out.println(avgScore);

		System.out.println(8.37 / 3);
	}

}
