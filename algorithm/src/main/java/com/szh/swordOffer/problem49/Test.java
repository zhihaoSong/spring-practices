package com.szh.swordOffer.problem49;

/**
 * Created by hztaoran on 2016/8/2.
 */
public class Test {
    public static void main(String[] args) {
        MyAtoI myAtoI = new MyAtoI();

//        System.out.println(myAtoI.myAtoi("+"));
//        System.out.println(myAtoI.myAtoi("-"));
//        System.out.println(myAtoI.myAtoi("+1"));
//        System.out.println(myAtoI.myAtoi("-1"));
//        System.out.println(myAtoI.myAtoi(""));
        System.out.println(myAtoI.myAtoi("-13213"));
        System.out.println(myAtoI.myAtoi("13213"));
        System.out.println(myAtoI.myAtoi("++++++"));
        System.out.println(myAtoI.myAtoi("+132A111111111113"));
        System.out.println(myAtoI.myAtoi("-132B111111111113"));
    }

}
