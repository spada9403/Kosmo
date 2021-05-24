package com.osh.day8_Exam;

import java.util.Scanner;

public class StudentScoreMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Student[] students = new Student[10];
		System.out.println("학생 성적을 입력하세요:(이름/학년/주소/수학/과학/영어/국어)");
		
		int count = 1;
		
		for(int i = 0;i < students.length; i++	) {
			students[i] = new Student();
		}
		
		for(Student student : students) {
			String[] data = sc.nextLine().split("/");
			if(data[1].equals("sum")) {
				int MathSum = 0;
				int SciSum = 0;
				int EngSum = 0;
				int LangSum = 0;
				for(int i = 0; i < count-1;i++) {
					MathSum += students[i].ScrObj[0].Score;
					SciSum += students[i].ScrObj[1].Score;
					EngSum += students[i].ScrObj[2].Score;
					LangSum += students[i].ScrObj[3].Score;
				}
				System.out.println("수학: "+ MathSum + "/" + (MathSum/(count-1)));
				System.out.println("과학: "+ SciSum + "/" + (SciSum/(count-1)));
				System.out.println("영어: "+ EngSum + "/" + (EngSum/(count-1)));
				System.out.println("국어: "+ LangSum + "/" + (LangSum/(count-1)));
				break;
			}
			student.StudentName = data[0];
			student.grade = Integer.parseInt(data[1]);
			student.address = data[2];
			for(int i = 0; i < student.ScrObj.length; i++) {
				student.ScrObj[i] = new Score();
				student.ScrObj[i].Score = Integer.parseInt(data[i+3]);
			}
			System.out.println((count) + "/10");
			count++;
		}
		
	}

}
