package com.szh.swordOffer;


import java.util.Stack;

/**
 * problem19
 * 二叉树的镜像
 *
 * @author hztaoran
 */
public class MirrorOfTree {
    public BTreeNode mirror(BTreeNode root) {
        if (null == root) {
            return null;
        }

        BTreeNode node = root;
        Stack<BTreeNode> stack = new Stack<>();
        while (null != node || !stack.isEmpty()) {
            while (node != null) {
                BTreeNode temp = node.leftChild;
                node.leftChild = node.rightChild;
                node.rightChild = temp;
                stack.push(node);
                node = node.leftChild;
            }
            node = stack.pop();
            node = node.rightChild;
        }

        return root;
    }

    public static void main(String[] args) {
        BTreeNode node1 = new BTreeNode();
        BTreeNode node2 = new BTreeNode();
        BTreeNode node3 = new BTreeNode();
        node1.leftChild = node2;
        node1.rightChild = node3;
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        MirrorOfTree mot = new MirrorOfTree();
        BTreeNode root = mot.mirror(node1);
        System.out.println(root.data + " " + root.leftChild.data + " " + root.rightChild.data);
    }
}
