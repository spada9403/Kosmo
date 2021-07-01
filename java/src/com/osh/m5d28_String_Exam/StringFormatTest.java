package com.osh.m5d28_String_Exam;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringFormatTest {

	public static void main(String[] args) {
		
//		%[argument_index$][flags][width]conversion
		
		
		// 필수요소인 conversion
		String str = String.format("%s %s", "홍길동","고길동");
		System.out.println(str);
		 // width 추가
		str = String.format("%5s %5s", "홍길동","고길동");
		System.out.println(str);
		// argument_index 추가
		str = String.format("%2$s %1$s", "홍길동","고길동");
		System.out.println(str);
		// flag
		str = String.format("%-10s %-10s", "홍길동","고길동"); // 왼쪽 정렬
		System.out.println(str);
		str = String.format("%10s %10s", "홍길동","고길동"); // 오른쪽 정렬
		System.out.println(str);
		// 부호 숫자만 가능
//		str = String.format("%+s %+s", "홍길동","고길동");
//		System.out.println(str);
		// 빈자리를 0으로 채움.
//		str = String.format("%010s %010s", "홍길동","고길동");
//		System.out.println(str);
		//이 외에도 ',' , '(' 등이 있다.
		
		/*
		 * 날짜 포맷
		 */
		//출력 형식 지정.
		String form = "yyyy년 MM월 dd일 hh시 mm분 ss초";
		// 생성할때 매개변수로 출력형식 전달.
		SimpleDateFormat sdf = new SimpleDateFormat(form);
		
		// 날짜
		Date dt = new Date();
		String now = dt.toString();
		System.out.println(now);
		// 출력형식을 전달해놓은 SimpleDateFormat 클래스에 .format 메소드의 매개변수로 Date 클래스를 넘겨주면 지정한 출력형식으로 만들어준다.
		System.out.println(sdf.format(dt));
		/*
		 * 숫자 포맷팅
		*/
		DecimalFormat df = new DecimalFormat("#,###.0"); // #,###0.0
		String result = df.format(1234459.99);
		System.out.println(result);
	}

}
