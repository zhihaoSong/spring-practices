package com.szh.swordOffer;

/**
 * Problem14
 * 调整数组使奇数位于偶数前面
 *
 * @author zhihao.song
 */
public class Reorder {
    public static void main(String[] args) {
        Reorder r = new Reorder();
        int[] a = {1, 2, 3, 4, 5, 6};
        r.order(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public void order(int[] a) {
        if (null == a || a.length <= 1) {
            return;
        }
        int low = 0;
        int high = a.length - 1;

        while (low < high) {
            while (low < high && (a[high] & 1) == 0) {
                high--;
            }
            while (low < high && (a[low] & 1) == 1) {
                low++;
            }
            if (low < high) {
                int temp = a[high];
                a[high] = a[low];
                a[low] = temp;
            }
        }
        return;
    }
}
