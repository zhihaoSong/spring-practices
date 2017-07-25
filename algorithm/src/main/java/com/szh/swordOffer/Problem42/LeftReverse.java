package com.szh.swordOffer.Problem42;

/**
 * Created by hztaoran on 2016/8/1.
 */
public class LeftReverse {

    public String leftReverse(String s, int n) {
        if (null == s || s.length() <= 0) {
            return null;
        }
        if (n < 0 || n > s.length()) {
            return null;
        }
        String reverse1 = core(s.substring(0, n));
        String reverse2 = core(s.substring(n, s.length()));

        System.out.println(reverse1);
        System.out.println(reverse2);

        String wholeReverse = reverse1 + reverse2;
        String res = core(wholeReverse);

        return res;
    }

    private String core(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length/2; i++) {
            char temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        return String.valueOf(array);
    }
}
