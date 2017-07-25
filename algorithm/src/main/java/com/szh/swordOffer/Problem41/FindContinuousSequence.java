package com.szh.swordOffer.Problem41;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem41扩展 和为s的连续正数序列]
 *
 * @author hztaoran
 */
public class FindContinuousSequence {

    public List<List<Integer>> find(int s) {
        List<List<Integer>> list = new ArrayList<>();
        if (s < 3) {
            return null;
        }

        int low = 1;
        int high = 2;
        while (low < (s + 1) /2) {
            int curSum = 0;
            for (int i = low; i <= high; i++) {
                curSum += i;
            }
            if (curSum == s) {
                List<Integer> tempList = new ArrayList<>();
                for (int i = low; i<= high; i++) {
                    tempList.add(i);
                }
                list.add(tempList);
                low++;
            } else {
                if (curSum > s) {
                    low++;
                } else {
                    high++;
                }
            }
        }

        return list;
    }
}
