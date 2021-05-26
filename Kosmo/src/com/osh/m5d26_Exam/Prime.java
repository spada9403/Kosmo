package com.osh.m5d26_Exam;

public class Prime {

	// 기본세팅
	public Prime() {
		
	}

	public Prime(int n) {
		if(n <= 0) {
			setPrime();
		} else {
			target = n;
			primeNumbers = new int[n];
			setPrime();
		}
	}

	// 멤버변수
	int target;
	int[] primeNumbers;
	
	
	// 기본생성자가 아닌 Number 세팅
	public void setNumber(int n) {
		if(n <= 0) {
			setPrime();
		} else {
			this.target = n;
			this.primeNumbers = new int[n];
			setPrime();
		}
	}

	// 입력받은 수까지의 소수를 배열에 저장.
	public void setPrime() {

		int count = 0;
		if (target == 0) {
			System.out.println("Please Set Number!! 0 < n");
			return;
		}

		for (int i = 1; i <= target; i++) {

			if (((i != 2) && (i % 2 == 0)) || ((i != 3) && (i % 3 == 0)) || (i != 5) && (i % 5 == 0)) {
				continue;
			} else {
				primeNumbers[count] = i;
			}

			count++;
		}

		return;
	}

	// 소수 배열 출력
	public void print() {
		if (primeNumbers.length == 0) {
			setPrime();
		} else {
			System.out.print("입력한 수까지의 소수 : ");
			for (int i : primeNumbers) {
				if (i == 0) {
					break;
				}
				System.out.print(i + " ");
			}
		}
	}
}
