package com.szh.swordOffer.problem24;

public class Test {
	public static void main(String args[]) {
		int[] a = {1,2,3,5,6,4};
		int[] b = {7,2,3,4};
		VerifySequenceOfBST vsob = new VerifySequenceOfBST();
		System.out.println(vsob.verifySequence(a) + " " + vsob.verifySequence(b));
	}
}
