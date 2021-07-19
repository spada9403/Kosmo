package com.osh.m5d27_Exam_Customer_Polymorphism;

public class CustomerMain {

	public static void main(String[] args) {
		Customer c1 = new Customer();
		c1.setCustomerID(10010);;
		c1.setCustomerName("이순신");
		c1.bonusPoint = 1000;
		
		System.out.println(c1.showCustomerInfo());
		
		Customer c2 = new VIPCustomer(10020,"김유신",12345);
		c2.bonusPoint = 1000;
		
		System.out.println(c2.showCustomerInfo());
		System.out.println("=========할인율과 보너스 포인트 계산 ========");
		
		int price = 10000;
		int c1Price = c1.calcPrice(price);
		int c2Price = c2.calcPrice(price);
		
		System.out.println(c1.getCustomerName() + " 님이 " + c1Price + "원 지불하셨습니다.");
		System.out.println(c1.showCustomerInfo());
		System.out.println(c2.getCustomerName() + " 님이 " + c2Price + "원 지불하셨습니다.");
		System.out.println(c2.showCustomerInfo());
	}

}
