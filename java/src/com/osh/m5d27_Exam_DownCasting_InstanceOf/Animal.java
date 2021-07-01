package com.osh.m5d27_Exam_DownCasting_InstanceOf;

import java.util.ArrayList;

public class Animal {
	ArrayList<Animal> aniList = new ArrayList<Animal>();
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
	public void addAnimal() {
		aniList.add(new Human());
		aniList.add(new Tiger());
		aniList.add(new Eagle());
		
		for(Animal ani: aniList) {
			ani.move();
		}
	}
public void testCasting() {
	for(int i = 0; i < aniList.size(); i++) {
		Animal ani = aniList.get(i);
		if(ani instanceof Human) {
			Human h = (Human)ani;
			h.readBook();
		} else if(ani instanceof Tiger){
			Tiger t = (Tiger)ani;
			t.hunting();
		} else if(ani instanceof Eagle){
			Eagle e = (Eagle)ani;
			e.flying();
		} else {
			System.out.println("지원되지 않는 형식입니다.");
		}
	}
}
	public static void main(String[] args) {
		Animal aTest = new Animal();
		aTest.addAnimal();
		System.out.println("원래 형으로 다운 캐스팅");
		aTest.testCasting();
	}
}
class Human extends Animal{
	@Override
	public void move() {
		System.out.println("사람이 두 발로 걷습니다.");
	}
	public void readBook() {
		System.out.println("사람이 책을 읽습니다.");
	}
}
class Tiger extends Animal{
	@Override
	public void move() {
		System.out.println("호랑이가 네 발로 뜁니다.");
	}
	public void hunting() {
		System.out.println("호랑이가 사냥을 합니다.");
	}
}
class Eagle extends Animal{
	@Override
	public void move() {
		System.out.println("독수리가 하늘을 납니다.");
	}
	public void flying() {
		System.out.println("독수리가 날개를 쭉 펴고 멀리 날아갑니다.");
	}
}
	



