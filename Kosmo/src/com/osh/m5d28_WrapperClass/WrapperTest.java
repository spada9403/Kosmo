package com.osh.m5d28_WrapperClass;

public class WrapperTest {

	public static void main(String[] args) {

		Integer ivalue = new Integer(100);

		// 박싱 -> 박싱 하는 이유를 나중에 다 찾아 봐야할듯.
		ivalue = Integer.valueOf(100);
		ivalue = Integer.valueOf("1000");

		// 언박싱
		int i = ivalue.intValue();
		i = Integer.parseInt("100");

		Byte bt = Byte.valueOf("11");
		byte b = Byte.parseByte("11");

		Float ft = Float.valueOf("2.4F");

		// 비교 연산

		ivalue = Integer.valueOf("1000");
		Integer i2 = Integer.valueOf("1000");

		if (ivalue.equals(i2))
			System.out.println("==");
		if (ivalue == i2)
			System.out.println("====");

	}

}
