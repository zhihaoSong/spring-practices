package com.szh.swordOffer;


/**
 * problem18 树的子结构
 *
 * @author hztaoran
 */
public class Tree1AndTree2 {

    /**
     * @param root1 主树
     * @param root2 目标树
     * @return
     */
    public boolean HasSubtree(BTreeNode root1, BTreeNode root2) {
        boolean flag = false;

        if (null != root1 && null != root2) {
            if (root1.data == root2.data) {
                flag = isSubTree(root1, root2);
            }
            if (!flag) {
                return HasSubtree(root1.leftChild, root2) || HasSubtree(root1.rightChild, root2);
            }
        }
        return flag;
    }

    private boolean isSubTree(BTreeNode root1, BTreeNode root2) {
        if (null == root2) {
            return true;
        }
        if (null == root1) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        } else {
            return isSubTree(root1.leftChild, root2.leftChild) && isSubTree(root1.rightChild, root2.rightChild);
        }
    }

    public static void main(String args[]) {
        BTreeNode root1 = new BTreeNode();
        BTreeNode node1 = new BTreeNode();
        BTreeNode node2 = new BTreeNode();
        BTreeNode node3 = new BTreeNode();
        BTreeNode node4 = new BTreeNode();
        BTreeNode node5 = new BTreeNode();
        BTreeNode node6 = new BTreeNode();
        root1.leftChild = node1;
        root1.rightChild = node2;
        node1.leftChild = node3;
        node1.rightChild = node4;
        node4.leftChild = node5;
        node4.rightChild = node6;
        root1.data = 8;
        node1.data = 7;
        node2.data = 2;
        node3.data = 9;
        node4.data = 2;
        node5.data = 4;
        node6.data = 7;
        BTreeNode root2 = new BTreeNode();
        BTreeNode a = new BTreeNode();
        BTreeNode b = new BTreeNode();
        root2.leftChild = a;
        root2.rightChild = b;
        root2.data = 8;
        a.data = 7;
        b.data = 2;
        Tree1AndTree2 tat = new Tree1AndTree2();
        System.out.println("==============");
        System.out.println(tat.HasSubtree(root1, root2));

    }
}