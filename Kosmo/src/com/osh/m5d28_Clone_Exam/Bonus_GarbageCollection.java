package com.osh.m5d28_Clone_Exam;



public class Bonus_GarbageCollection {

	static class Employee { // inner class 를 메인에서 사용하기 위해서는 static을 붙여 미리 메모리에 로드 해놔야 한다.
		int eno;
		public Employee(int eno) {
			this.eno = eno;
			System.out.println("Emplyee" + eno + "생성");
			
		}
		
		@Override
		protected void finalize() throws Throwable {
			System.out.println("Emplyee" + eno + " 삭제");
		}
	}
	public static void main(String[] args) {
		Employee emp = new Employee(1);
		emp = null;
		emp = new Employee(2);
		emp = new Employee(3);
		System.out.println("Emplyee " + emp.eno);
		System.gc();
		
	}

}
