package com.osh.day5;

public class BitOperation {

	public static void main(String[] args) {
		int num1 = 3; // 0011
		int num2 = 10;// 1010

		int result = num1 & num2; // 0010
		System.out.println(result);
		result = num1 | num2; // 1011 �Ѵ� 0�̸� 0 �ܿ��� 1.
		System.out.println(result);
		result = ~num1; // 1100(��ȣ��Ʈ ����!) 1(��ȣ��Ʈ)100 = -4
		System.out.println(result);
		result = num1 ^ num2; // �� ��Ʈ�� �޶������ 1 0011 ^ 1010 = 1001
		System.out.println(result);
		// �� �����ڿ� ��Ʈ �� ������ ����
		boolean t = (num1 >= num2) && (num1 <= num2);
		// t = (num1 & num2) && (num1 ^ num2); ���� true false �� �ƴ� ���� ���� ������
		// ������ �������� ������ ��������. ����!!
		// boolean ���� ��Ʈ������ ����!
		t = (5 > 10) & (10 < 20);
		System.out.println(t);
		t = (5 < 10) & (10 < 20);
		System.out.println(t);
		/*
		 * shift operator bit wise operation - left, right, 0ä�� << ������ = �������� n
		 * ��Ʈ �̵� > ���� ���� 2^n ���Ѵ�. (5 << 2 => 5 * 2^2 => 20) 0101 > 10100 >>
		 * ������ = // �������� 2^n ������. >>> ������ = >> ����� ����. ������
		 * ä�����º�Ʈ���� ��ȣ��Ʈ�� ������� ������ 0 �̵ȴ�
		 */

		int num3 = 5;
		int num4 = -5;

		System.out.println(num3 << 3);
		System.out.println(num4 << 3);

		System.out.println(num3 >> 2);
		System.out.println(num4 >> 2);

		System.out.println(num4 >>> 1);
		System.out.println(num3 >>> 1);
	}

}

/*
 * 1010 = 10 1011 = 7 &1010 = 10 |1011 = 11 ^0001 = 1 !10~0101 = 4
 * 
 */