package com.osh.m5d28_Clone_Exam;


class Point {
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x =  x;
		this.y = y;
	}

	/*
	 * @Override public boolean equals(Object obj) { if(obj instanceof Point) {
	 * Point p = (Point)obj; if(this.x == p.x && this.y == p.y) return true; else
	 * return false; } else return false; }
	 * 
	 * @Override public int hashCode() { return x; }
	 * 논리 값이 같을때, 다른 인스턴스 주소 값을 가지고 있더라도 같다고 표현 하려면, equlas와 hashCode를 오버라이딩 해야 하는데
	 * 다른 방법도 있다.
	 */
	public String toString() {
		return "x = " + x + "," + "y = "+ y;
	}
}
class Circle implements Cloneable{ // 뭔지는 잘 모르겟지만 객체를 복제해도 된다는 의미로 Cloneable 인터페이스를 사용.
	Point point;
	int radius;
	Circle(int x, int y, int radius){
		this.radius = radius;
		point = new Point(x,y);
	}
	public String toString() {
		return "원점은 " + point + "이고," + "반지름은" + radius + "입니다";
	}
	@Override
	public Object clone() throws CloneNotSupportedException{ // clone() 메서드를 사용할 떄 발생할 수 있는 오류를 예외 처리함.
		return super.clone();
	}
}
/*
 * clone() 메서드는 protected Object clone();
 * 라고 선언되어 있고, 객체를 복제해 또 다른 객체를 반환해 주는 메서드이다.
 */

public class ObjectCloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Circle circle = new Circle(10,20,30);
		Circle circle2 = circle; // 얕은 복사 인스턴스 주소 값 까지 같이 복사함. circle 값이 바뀌면 같이 바뀐다.
		Circle copyCircle = (Circle)circle.clone(); // 깊은 복사 인스턴스 주소 값이 달라 따로 관리가 가능.
		
		System.out.println(circle);
		System.out.println(copyCircle);
		System.out.println(System.identityHashCode(circle));
		System.out.println(System.identityHashCode(circle2));
		System.out.println(System.identityHashCode(copyCircle));
	}

}
