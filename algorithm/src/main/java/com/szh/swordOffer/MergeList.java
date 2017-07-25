package com.szh.swordOffer;


/**
 * problem17
 * 输入两个递增的链表，合并这两个链表并使新链表仍然是递增的
 *
 * @author zhihao.song
 */
public class MergeList {
    public static void main(String args[]) {
        ListNode a1 = new ListNode();
        ListNode a2 = new ListNode();
        a1.next = a2;
        a1.data = 1;
        a2.data = 5;

        ListNode b1 = new ListNode();
        ListNode b2 = new ListNode();
        ListNode b3 = new ListNode();
        b1.next = b2;
        b2.next = b3;
        b1.data = 2;
        b2.data = 3;
        b3.data = 4;

        MergeList ml = new MergeList();
        ListNode node = ml.merge(a1, b1);
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public ListNode mergeRecursively(ListNode root1, ListNode root2) {
        if (null == root1) {
            return root2;
        } else if (null == root2) {
            return root1;
        }
        ListNode newHead = null;

        if (root1.data <= root2.data) {
            newHead = root1;
            newHead.next = merge(root1.next, root2);
        } else {
            newHead = root2;
            newHead.next = merge(root1, root2.next);
        }

        return newHead;
    }

    /**
     * 非递归
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode newHead = null;
        if (list1.data <= list2.data) {
            newHead = list1;
            list1 = list1.next;
        } else {
            newHead = list2;
            list2 = list2.next;
        }

        ListNode p = newHead;
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        if (list1 != null) {
            p.next = list1;
        } else if (list2 != null) {
            p.next = list2;
        }

        return newHead;
    }

}
