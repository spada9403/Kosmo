package com.osh.day5;

public class SwitchExam {

	public static void main(String[] args) {
		int ranking = 3;
		char medalColor;

		switch (ranking) { // ���ǽĿ� ���� �Ӹ��� �ƴ� ���ڿ��� ��� �����ϴ�.
		case 1:
			medalColor = 'G'; // break�� ���� ������ ��� case�ڵ���� ����ȴ�.
			break;
		case 2:
			medalColor = 'S';
			break;
		case 3:
			medalColor = 'B';
			break;
		default:
			medalColor = 'A';
		}
		System.out.println(ranking + "�� �޴��� ������ " + medalColor + "�Դϴ�.");
	}

}
