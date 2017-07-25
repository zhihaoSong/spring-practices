package com.szh.swordOffer.problem37;

import com.ryan.offer.node.ListNode;

/**
 * Problem37
 * way1 蛮力时间O(m*n)
 * way2 利用栈时间O(m+n) 空间O(m+n)
 * way3 时间O(m+n)
 *
 * @author hztaoran
 */
public class Test {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(6);
        ListNode a5 = new ListNode(7);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode b1 = new ListNode(4);
        ListNode b2 = new ListNode(5);
        b1.next = b2;
        b2.next = a4;

        System.out.println(new FirstCommonNode().find(a1, b1));
    }
}
