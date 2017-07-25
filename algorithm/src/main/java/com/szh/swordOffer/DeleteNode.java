package com.szh.swordOffer;


/**
 * Problem 13
 * 给定单向链表的头指针和一个节点，定义一个函数在O(1)时间删除该节点
 *
 * @author zhihao.song
 */
public class DeleteNode {
    public static void main(String args[]) {
        ListNode a = new ListNode();
        ListNode b = new ListNode();
        ListNode c = new ListNode();
        a.next = b;
        b.next = c;
        a.data = 1;
        b.data = 2;
        c.data = 3;
        DeleteNode dn = new DeleteNode();
        ListNode head = dn.deleteNode(a, a);
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public ListNode deleteNode(ListNode head, ListNode node) {
        if (null == node || null == head) {
            return head;
        }
        if (head == node) {
            ListNode next = head.next;
            head = null;
            return next;
        } else {
            if (node.next == null) {
                ListNode p = head;
                while (p.next.next != null) {
                    p = p.next;
                }
                p.next = null;
            } else {
                node.data = node.next.data;
                node.next = node.next.next;
            }

            return head;
        }
    }
}
