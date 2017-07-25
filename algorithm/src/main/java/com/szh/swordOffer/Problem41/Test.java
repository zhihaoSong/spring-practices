package com.szh.swordOffer.Problem41;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hztaoran on 2016/8/1.
 */
public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 7, 11, 15};
        System.out.println(Arrays.toString(new FindNumbersWithSum().find(a, 15)));

        List<List<Integer>> list = new FindContinuousSequence().find(9);
        System.out.println(list);
    }
}
