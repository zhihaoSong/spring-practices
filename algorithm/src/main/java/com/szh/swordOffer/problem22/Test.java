package com.szh.swordOffer.problem22;

public class Test {
	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = { 4, 3, 5, 2, 1 };
		IsPopOrder test = new IsPopOrder();
		System.out.println(test.IsPopOrder(array1, array2));
	}
}
