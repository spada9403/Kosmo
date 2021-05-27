package com.osh.m5d27_Exam_BusAndTaxi;

public class Driver {
	public void drive(Vehicle vehicle) {
		vehicle.run();
		vehicle.info();
		/*
		 * Q. vehicle 클래스에 info 메소드가 없더라고
		 * drive 메소드가 받는 Vehicle은 Bus, Taxi의 인스턴스 이기 때문에,
		 *  vehicle.info();를 사용 할수 있다고 생각함.
		 *  왜냐하면 vehicle 의 info메서드가 있다 해도, vehicle의 info 메서드와
		 *  Bus, Taxi의 info 메서드는 메소드가 저장되있는 메모리의 위치자료값(참조값)이 다르기 때문에,
		 *  Bus, Taxi로 인스턴스를 받으면 info메소드 의 참조값이 있어 실행이 가능할거라 생각함.
		 */
		
		/*
		 * Bus, Taxi 의 info는 각각 클래스에서 추가된 메서드이기때문에
		 * 실제로 Bus, Taxi의 인스턴스가 만들어질때 Info의 메소드는 각각 클래스의 Info 메서드를
		 * 가르키는 참조값을 가지지만, 자료형이 Vehicle 이기 때문에,
		 * Vehicle에서 가지지 못한 모든 멤버 변수 / 메서드를 사용할수 없다.
		 * Vehicle에 존재하는 메서드를 오버라이딩 한것이라면, Bus,Taxi의 오버라이딩한 메서드의 참조값을 가져오지만,
		 * Vehicle 자식 클래스 각각이 추가로 생성한 메소드는 가져오지 못한다. 
		 * 결론. Vehicle에 Info 메서드가 없고, 오버라이딩 하지 않아서 참조값이 있어도 가져다가 사용하지 못한다.
		 */
	}
}
