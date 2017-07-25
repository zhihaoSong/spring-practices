package com.szh.swordOffer.Problem42;

/**
 * Created by hztaoran on 2016/8/1.
 */
public class ReverseWord {
    public String reverse(String s) {
        if (null == s || s.length() <= 0) {
            return null;
        }

        String wholeReverse = core(s);
        String[] wholeReverseArr = wholeReverse.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String val : wholeReverseArr) {
            sb.append(core(val)).append(" ");
        }

        return sb.toString();
    }

    private String core(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        return String.valueOf(array);
    }
}
