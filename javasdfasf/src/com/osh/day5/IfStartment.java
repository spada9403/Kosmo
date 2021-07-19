package com.osh.day5;

public class IfStartment {

	public static void main(String[] args) {

		int age = 10;
		// ���� 1
		if (age >= 8) {
			System.out.println("8888");
		} else {
			System.out.println(8);
		}
		// ���� ����
		int age2 = 10;
		if ((age >= 8) && (age2 > 10)) {
			System.out.println(8888);
		} else {
			System.out.println(8);
		}
		// ���� if�� ���� �ʰ� else-if else �� ���̾���.
		int score = 70;

		if (score >= 70) {
			System.out.println("�հ�");
		} else if (score >= 50) { // score �� 70 ���� ������ ����.
			System.out.println("�����");
		} else {// if�� ���� ���ʴ�� ������ ���ϰ� ������ �����ʴ� ��� ��� ����.
			System.out.println("���հ�");
		}
		// ����

		int age1 = 7;
		int charge = 0;

		if (age1 < 8) {
			System.out.println("���� �� �Ƶ��Դϴ�.");
		} else if (age1 < 14) { // else if ���� �׳� if�� ���� ������ �ٽ� ���Ѵ�. age1�� 7�� �ְ� ���� if�� �ٲ㺸��
								// ���δ� ��µǴ°��� �� �� �ִ�.
			charge = 2000;
			System.out.println("�ʵ��л��Դϴ�.");
		} else if (age1 < 20) {
			charge = 2500;
			System.out.println("��,����л��Դϴ�.");
		} else {
			charge = 3000;
			System.out.println("�Ϲ����Դϴ�.");
		}
		System.out.println("������ " + charge + "���Դϴ�.");

	}

}
