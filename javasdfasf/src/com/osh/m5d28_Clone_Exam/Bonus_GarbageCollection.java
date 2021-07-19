package com.osh.m5d28_Clone_Exam;



public class Bonus_GarbageCollection { // 외부 클래스

	static class Employee { // inner class 를 메인에서 사용하기 위해서는 static을 붙여 미리 메모리에 로드 해놔야 한다. static을 붙이지 않는다면 밖으로 빼면 된다.
		int eno;
		public Employee(int eno) {
			this.eno = eno;
			System.out.println("Emplyee" + eno + "생성");
			
		}
		
		@Override
		protected void finalize() throws Throwable { // finalize -> 객체가 GC에 의해 없어질때 마지막으로 호출하는 메소드 이다.
			System.out.println("Emplyee" + eno + " 삭제");
		}
	}
	public static void main(String[] args) {
		Employee emp = new Employee(1);
		emp = null;
		emp = new Employee(2);
		emp = new Employee(3);
		System.out.println("Emplyee " + emp.eno);
		System.gc(); // 가비지 컬렉터 호출.
		
	}

}
