package com.osh.day5;

public class StringConcat {

	public static void main(String[] args) {

		String s = "";

		/** ���ڿ� ������ '+'�� ���ӻ� **/
		System.out.println("1+1 = " + " ���" + (1 + 1));

		System.out.println("�����ڵ� = " + "\uADAC");

		System.out.println("�����ڵ� escape " + "\\uADAC");

		System.out.println("���� + ���� = " + 5 + 10);

		System.out.println("���� + �Ǽ� = " + 5 + 10.9);

		System.out.println(5 + 10.9 + " = ���� + �Ǽ�");
	}

}
