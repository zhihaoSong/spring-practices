package com.szh.swordOffer.problem30;

public class Test {
	public static void main(String args[]) {
		int[] array = { 4, 5, 1, 6, 2, 7, 3};
//		GetLeastNumbersWithHeap test1 = new GetLeastNumbersWithHeap();
//		test1.getLeastNumbers(array, 4);
//		System.out.println("=====================");
		GetLeastNumbersWithPartition test2 = new GetLeastNumbersWithPartition();
		test2.getLeastNumbers(array, 3);
	}
}
