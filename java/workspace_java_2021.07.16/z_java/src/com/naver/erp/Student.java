package com.naver.erp;

public class Student {
	private int stu_no;
	private String stu_name;
	private String jumin_num;
	
	//생성자 선언하기
	
		public Student ( int stu_no, String stu_name, String jumin_num ) {
			
		}
	
	//메소드 선언하기
		
		public void setStu_no( int stu_no ) {
			this.stu_no = stu_no;
		}
		public int getStu_no() {
			return this.stu_no;
		}
		public void setStu_no( String stu_name ) {
			this.stu_name = stu_name;
		}
		public String getStu_name() {
			return this.stu_name;
		}
		public void setJumin_num( String jumin_num ) {
			this.jumin_num = jumin_num;
		}
		public String getJumin_num() {
			return this.jumin_num;
		}
}
/*
 	<1>자바에서 최소 단위 프로그램은?
 		
	 		Class 클래스.
	 			
		 			객체의 전신이다. 즉, 객체를 생성하기 위한 단위 프로그램이다.
		 			
		 			속성변수(=멤버변수), 생성자, 메소드로 구성되어있따.
		 			속성변수에는 동료 속성변수/메소드/생성자에서 공용으로 사용할 데이터가 저장된다.
		 			메소드에는 실행 코드(=실행 구문)이 저장된다.
		 			생성자는 객체 생성 시 단 한번 호출되는 것으로 외부에서 데이터가 들어온다.
	 			
	 		Interface 인터페이스.
	 		
	 				public, static, final 의 성격을 가진 속성변수와
	 				public, abstract 의 성격을 가진 메소드로만 구성된 단위 프로그램이다.
	 				객체 생성 목적으로 만들어지지 않았따.
	 				클래스의 설계도 역활을 한다.
*/

