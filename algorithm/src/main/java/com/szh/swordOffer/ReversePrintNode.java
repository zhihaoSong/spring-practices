package com.szh.swordOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 3.从尾到头打印单链表
 */
public class ReversePrintNode {
    // 使用栈
    public List<ListNode> print(ListNode head) {
        List<ListNode> list = new ArrayList<ListNode>();
        if (null == head)
            return null;
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
    /*
    递归实现
     */

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> reversePrintList = new ArrayList<Integer>();
        deepReverse(reversePrintList, listNode);
        return reversePrintList;
    }


    public void deepReverse(ArrayList<Integer> reversePrintList, ListNode initListNode) {
        if (initListNode != null) {
            deepReverse(reversePrintList, initListNode.next);
            reversePrintList.add(initListNode.data);
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        node1.next = node2;
        node2.next = node3;

        ReversePrintNode rpn = new ReversePrintNode();
        List<ListNode> list = rpn.print(node1);
        for (ListNode node : list) {
            System.out.println(node.data);
        }
    }
}
