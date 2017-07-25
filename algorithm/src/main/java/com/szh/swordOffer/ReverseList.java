package com.szh.swordOffer;

/**
 * problem16
 * 反转链表
 *
 * @author zhihao.song
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        ListNode forth = new ListNode();
        head.next = second;
        second.next = third;
        third.next = forth;

        head.data = 1;
        second.data = 2;
        third.data = 3;
        forth.data = 4;
        ReverseList test = new ReverseList();
        ListNode node = test.reverse(head);
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public ListNode reverse(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
//            if (cur.next == null) {
//                cur.next = pre;
//                return cur;
//            }
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
