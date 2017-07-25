package com.szh.swordOffer.problem26;

/**
 * Created by hztaoran on 2016/7/15.
 */
public class Test {
    public static void main(String[] args) {
        ComplexListNode A = new ComplexListNode(0);
        ComplexListNode B = new ComplexListNode(1);
        ComplexListNode C = new ComplexListNode(2);
        ComplexListNode D = new ComplexListNode(3);
        ComplexListNode E = new ComplexListNode(4);

        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;

        A.sibling = C; // 2
        B.sibling = E; // 4
        D.sibling = B; // 1

        ComplexListNode newHead = new ComplexListClone().cloneList(A);

        while (null != newHead) {
            System.out.println("data域:" + newHead.data + ", sibling域:" + newHead.sibling);
            newHead = newHead.next;
        }
    }
}
