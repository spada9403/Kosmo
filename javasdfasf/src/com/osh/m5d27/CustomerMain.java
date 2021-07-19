package com.osh.m5d27;

public class CustomerMain {

	public static void main(String[] args) {
		Customer c1 = new Customer();
		// 문제가 됨 c1.customerName = "홍길동"
		c1.setCustomerName("홍길동");
		c1.setCustomerID(1);
		c1.bonusPoint = 1000;

		System.out.println(c1.showCustomerInfo());
		System.out.println(c1.calcPrice(10000));
//		Customer c2 = new Customer(10,"강감찬");

//		System.out.println(c2.showCustomerInfo());

		VIPCustomer VIP = new VIPCustomer();
		VIP.setCustomerID(10020);
		VIP.setCustomerName("김유신");
		VIP.bonusPoint = 10000;
		System.out.println(VIP.showCustomerInfo());
		System.out.println(VIP.calcPrice(10000));

		// 객체 캐스팅 상속받은 자식 클래스는 부모클래스 자료형으로 담을수 있다.(묵시적 클래스형 변환)
		Customer c3 = new VIPCustomer();
		c3.setCustomerName("이순신");
		System.out.println(c3.calcPrice(10000));
		// short 형에 int 형을 담고, short형을 다시 int형에 담을수 있는것과 같다.
	}

}
