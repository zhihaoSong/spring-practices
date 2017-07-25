package com.szh.swordOffer.problem36;

/**
 * Problem36
 * 数组中的逆序对
 *
 * way1 一一比较O(n^2)
 * way2 -- 归并排序O(nlgn)
 *
 * @author hztaoran
 */
public class InversePairs {
    public int getInversePairs(int[] data) {
        if (null == data || data.length < 2) {
            return 0;
        }
        int[] copy = data.clone();

        return core(data, copy, 0, data.length - 1);
    }

    private int core(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int len = (end - start) / 2;
        int left = core(copy, data, start, start + len);
        int right = core(copy, data, start + len + 1, end);

        int i = start + len;
        int j = end;
        int k = end;
        int count = 0;

        while (i >= start && j >= start + len + 1) {
            if (data[i] > data[j]) {
                copy[k--] = data[i--];
                count += j - start -len;
            } else {
                copy[k--] = data[j--];
            }
        }

        for (; i >= start; i--) {
            copy[k--] = data[i];
        }

        for (; j >= start + len + 1; j--) {
            copy[k--] = data[j];
        }

        return left + right + count;
    }
}
