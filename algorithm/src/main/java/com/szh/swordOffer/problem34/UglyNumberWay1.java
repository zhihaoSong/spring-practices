package com.szh.swordOffer.problem34;

/**
 * Problem34
 * 丑数:只包含因子2,3,5的数称为丑数
 *
 * @author hztaoran
 */
public class UglyNumberWay1 {
	public int getUglyNumber(int index) {
		if (index <= 0) {
			return 0;
		}
		int number = 0;
		int count = 0;
		while (count < index) {
			number++;
			if (isUgly(number)) {
				count++;
			}
		}
		return number;
	}
	
	private boolean isUgly(int number) {
		while (number % 2 == 0) {
			number /= 2;
		}
		while (number % 3 == 0) {
			number /= 3;
		}
		while (number % 5 == 0) {
			number /= 5;
		}
		
		return (1 == number) ? true : false;
	}
}
