package com.szh.swordOffer.Problem41;

/**
 * Problem41 查找排序数组中等于指定数字的两个数
 * way1 固定1个数字 O(n^2)
 * way2 双指针两端向中间扫描O(n)
 */
public class FindNumbersWithSum {

    public int[] find(int[] a, int n) {
        if (null == a || a.length <= 0) {
            return null;
        }

        int low = 0;
        int high = a.length - 1;

        while (low < high) {
            int curSum = a[low] + a[high];
            if (curSum == n) {
                return new int[] {a[low], a[high]};
            } else {
                if (curSum > n) {
                    high--;
                } else {
                    low ++;
                }
            }
        }

        return null;
    }

}
