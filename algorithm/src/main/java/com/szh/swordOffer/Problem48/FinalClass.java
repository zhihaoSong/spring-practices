package com.szh.swordOffer.Problem48;

/**
 * Problem48
 * 不能被继承的类
 *
 * @author hztaoran
 */
public class FinalClass {

    public static FinalClass getInstance() {
        return new FinalClass();
    }

    private FinalClass() {
    }
}
