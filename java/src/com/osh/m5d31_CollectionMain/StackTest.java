package com.osh.m5d31_CollectionMain;

import java.util.ArrayList;

import com.osh.m5d31_Collection.Member;

class MyStack {
	private ArrayList<Member> arrayStack = new ArrayList<Member>();
	
	public void push(Member data) {
		arrayStack.add(data);
	}
	
	public Member pop() {
		int len = arrayStack.size();
		if(len == 0) {
			System.out.println("스택이 비었습니다.");
			return null;
		}
		
		return(arrayStack.remove(len-1));
	}
}

public class StackTest{
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(new Member(001,"홍길동"));
		stack.push(new Member(002,"고길동"));
		stack.push(new Member(003,"둘리"));
		
		System.out.println(stack.pop().getMemberName());
		System.out.println(stack.pop().getMemberName());
		System.out.println(stack.pop().getMemberName());
		
	}
}
