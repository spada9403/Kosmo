package com.osh.m5d26;

public class CustomerMain {

	public static void main(String[] args) {
		Customer c1 = new Customer();
		// 문제가 됨 c1.customerName = "홍길동"
		c1.setCustomerName("홍길동");
		c1.setCustomerID(1);
		c1.bonusPoint = 1000;
		
		System.out.println(c1.showCustomerInfo());
		
//		Customer c2 = new Customer(10,"강감찬");

//		System.out.println(c2.showCustomerInfo());

		VIPCustomer VIP = new VIPCustomer();
		VIP.setCustomerID(10020);
		VIP.setCustomerName("김유신");
		VIP.bonusPoint = 10000;
		System.out.println(VIP.showCustomerInfo());
	}

}
