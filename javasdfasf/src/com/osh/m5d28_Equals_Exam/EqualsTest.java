package com.osh.m5d28_Equals_Exam;
class Student{
	int studentId;
	String studentName;
	
	public Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
	}
	@Override
	public String toString() {
		return studentId + ", " + studentName;
	}
	// Equals() 메서드 재정의해서 논리적값이 같을때도 같다고 하기.
	
//	@Override // String class와 Integer 클래스는 이미 equals 메소드가 재정의 되어있다.
//	public boolean equals(Object obj) {
//		if(obj instanceof Student) {
//			Student std = (Student)obj;
//			if(this.studentId == std.studentId) {
//				return true;
//			}else
//				return false;
//		} else
//			return false;
//	}
	@Override
	public int hashCode() {
		return studentId;
	}
}
public class EqualsTest {
	public static void main(String[] args) {
		Student studentLee = new Student(100, "이상원");
		Student studentLee2 = studentLee;
		Student studentSang = new Student(100, "이상원");
		
		if(studentLee == studentLee2)
			System.out.println("Lee1 == Lee 2");
		else
			System.out.println("Lee1 != Lee 2");
		if(studentLee.equals(studentLee2))
			System.out.println("Equals Lee1 == Lee2");
		else
			System.out.println("Equals Lee1 != Lee2");
		
		if(studentLee == studentSang)
			System.out.println("Lee1 == studentSang");
		else
			System.out.println("Lee1 != studentSang");
		if(studentLee.equals(studentSang))
			System.out.println("Equals Lee1 == studentSang");
		else
			System.out.println("Equals Lee1 != LstudentSang");
		
		System.out.println(studentLee.hashCode());
		System.out.println(studentSang.hashCode());
		System.out.println(System.identityHashCode(studentLee));
		System.out.println(System.identityHashCode(studentSang));
		
	}

}
