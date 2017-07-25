package com.szh.swordOffer;


/**
 * Problem15
 * 输入一个链表，输出该链表的倒数第K个结点
 *
 * @author zhihao.song
 */
public class FindKthToTail {
    public static void main(String args[]) {
        ListNode a1 = new ListNode();
        ListNode a2 = new ListNode();
        ListNode a3 = new ListNode();
        ListNode a4 = new ListNode();
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a1.data = 1;
        a2.data = 2;
        a3.data = 3;
        a4.data = 4;
        FindKthToTail fkt = new FindKthToTail();
        ListNode node = fkt.findKthOfTail(a1, 4);
        System.out.println(node.data);
    }

    public ListNode findKthOfTail(ListNode head, int k) {
        if (null == head || k <= 0) {
            return null;
        }
        ListNode p = head;
        for (int i = 0; i < k - 1; i++) {
            if (p.next != null) {
                p = p.next;
            } else {
                return null;
            }
        }
        ListNode q = head;
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }

}
