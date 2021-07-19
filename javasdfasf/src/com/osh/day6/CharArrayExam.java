package com.osh.day6;

public class CharArrayExam {

	public static void main(String[] args) {
		char[] alphabets = new char[26];
		char ch = 'A';

		for (int i = 0; i < alphabets.length; i++, ch++) {
			alphabets[i] = ch;
		}
		for (int i = 0; i < alphabets.length; i++) {
			System.out.println(alphabets[i] + "," + (int) alphabets[i]);
		}
	}

}
