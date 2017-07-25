package com.szh.swordOffer.problem28;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Problemn28
 * 字符串的全排列
 *
 * @author hztaoran
 */
public class PermutationOfString {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (null == str || str.length() <= 0) {
            return list;
        }

        int low = 0;
        int high = str.length() - 1;

        TreeSet<String> set = new TreeSet<>();
        permCore(set, str.toCharArray(), low, high);

        list.addAll(set);

        return list;
    }

    private void permCore(TreeSet<String> set, char[] a, int low, int high) {
        if (low == high) {
            set.add(String.valueOf(a));
        } else {
            for (int i = low; i <= high; i++) {
                swap(a, i, low);
                permCore(set, a, low + 1, high);
                swap(a, i, low);
            }
        }
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
