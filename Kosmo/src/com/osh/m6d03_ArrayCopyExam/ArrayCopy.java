package com.osh.m6d03_ArrayCopyExam;

public class ArrayCopy {
	
	public void arrayCopy(int[] src,int srcPos, int[]dst,int dstPos,int length){
		// return 해줄 필요가 없다. arr,darr의 참초 레퍼런스(실재 메모리 주소 값) 을 가지고 와서 변경하기 때문이다. src, dst가 새로운 참조값을 가진(레퍼런스를 가진) 객체가 아니라,  arr, darr의 참조값을 담고있는 변수이다.
		for(int i = 0; i < length; i++) {
			dst[dstPos + i] = src[srcPos + i];
		}
	}

	public static void main(String[] args) {
		ArrayCopy a = new ArrayCopy();
		
		int[] arr = {0,1,2,3,4,5,6,7,8,9,10};
		int[] darr = new int[20];
		
		a.arrayCopy(arr, 5, darr, 10, 6);
		
		for(int i : darr) {
			System.out.print(i + " ");
		}
		
	}

}
