package com.szh.swordOffer.problem21;

/**
 * Created by hztaoran on 2016/7/11.
 */
public class Test {
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        System.out.println(stack.min());
        stack.push(4);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        stack.push(1);
        System.out.println(stack.min());
    }
}
