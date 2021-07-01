package com.osh.m5d25_Class_Training;

public class OrderMain {

	public static void main(String[] args) {

		Order order = new Order();

		order = order.setOrder(1, "seahwang", "2021/05/25", "오세황", "46853", "서울 금천구");

		for (String a : (order.getOrder())) {
			System.out.println(a);
		}

	}

}
