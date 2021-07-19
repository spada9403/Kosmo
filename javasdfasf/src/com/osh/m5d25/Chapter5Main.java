package com.osh.m5d25;
// import com.osh.day8_Exam.Student;

import com.osh.m5d25_sub.Person;

public class Chapter5Main {

	// public static <<< static은 main클래스에서 메서드들이 사용하는것인데 일반적인 클래스 파일에서는 쓰지 않는다.
	// 그리고 메인 클래스에서 메서드를 만드는것은 되도록 하지 않는다.
	public static void main(String[] args) {
		Student st = new Student(); // com.osh.m5d25.Student;
		// com.osh.day8_Exam.Student st2 = new Student();
		// 클래스를 객체화 시키면 . operator 로 클래스 안의 멤버필드/멤버 매서드에 접근이 가능하다.

		// 다른 패키지의 클래스를 가져왔을때, 멤버 필드를 . operator로 접근이 불가능하다.
		Person p = new Person();

		st.studentID = 1000; // 웬만하면 이런식으로 직접적으로 변경을 못하게 한다. (접근 통로를 줄인다.)
		st.studentName = "홍길동"; // 불안정함 없애기위해. 메서드를 통해 바꿀수 있도록 제공하는게 좋다.

		// 사용
		System.out.println(st.studentName);

		// 2. 반환형식이 있다.
		String info = st.showStudentInfo();
		System.out.println(info);

		// System.out.println(st.showStudentInfo());

		// 3. 반환형식이 없다.
		st.println();

		// 4. 매개변수를 사용.
		System.out.println(st.setScore(100));

		// 아래 방식을 더 많이 사용한다.
		st.setScore2(100);
		System.out.println(st.showStudentInfo());

		// 다른 패키지의 클래스 파일.
		// com.osh.day8_Exam.Student st3 = new com.osh.day8_Exam.Student();

	}

}
