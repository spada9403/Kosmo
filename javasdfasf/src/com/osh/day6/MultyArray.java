package com.osh.day6;

import java.util.Arrays;
import java.util.Iterator;

public class MultyArray {

	public static void main(String[] args) {
		// 2 X 3배열 : 행우선
		int[][] arr = new int[2][3];

		System.out.println("행 : " + arr.length);
		System.out.println("열 : " + arr[0].length);
		System.out.println("열 : " + arr[1].length);

		for (int i = 0; i < arr.length; i++) { /// 행
			for (int j = 0; j < arr.length; j++) {/// 열
				arr[i][j] = 1; // 행 X 열
			}
		}
		// System.out.println(Arrays.toString(arr));
	}

}
