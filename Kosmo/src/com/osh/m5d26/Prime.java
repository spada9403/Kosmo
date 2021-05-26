package com.osh.m5d26;

public class Prime {
	
	public Prime()	{
		target = 0;
		primeNumbers = new int[0];
	}
	public Prime(int n)	{
		target = n;
		primeNumbers = new int[n];
		setPrime();
	}
	
	int target;
	int[] primeNumbers;
	
	
	public void setPrime() {
		
		int count = 0;
			
			for(int i = 1; i <= target; i++) {
				
				if(target == 0) {
					System.out.println("Please Set Number!! 0 < n");
					return;
				} else {
					if( ((i != 2) && (i % 2 == 0)) || ((i != 3) && (i % 3 == 0)) || (i != 5) && (i % 5 == 0)) {
						continue;
					} else {
						primeNumbers[count] = i;
					}
				}
				count++;
			}
			
			return;
	}
	
	public void print() {
		if(primeNumbers.length == 0) {
			setPrime();
		} else {
			System.out.print("입력한 수까지의 소수 : ");
			for(int i:primeNumbers) {
				if(i == 0) {
					break;
				}
				System.out.print(i + " ");
			}
		}
	}
}
