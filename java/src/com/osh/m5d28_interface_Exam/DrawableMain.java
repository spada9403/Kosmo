package com.osh.m5d28_interface_Exam;

public class DrawableMain {

	public static void main(String[] args) {
		
		Drawable[] drawables = new Drawable[] {
				new Rectangle(5, 8, 8, 9)
		};
		
		for(Drawable d : drawables) {
			d.draw(Drawable.RED);
		}
		
	}

}
