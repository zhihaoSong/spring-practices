package com.szh.swordOffer;

import java.util.Arrays;

/**
 * 6.根据二叉树前序和中序重建二叉树
 */
public class ConstructBTree {
    /**
     * 输入二叉树的前序遍历和中序遍历结果,重建二叉树并输出头节点
     * e.g.12473568,47215386
     */
    public BTreeNode construct(int[] preorder, int[] inorder) throws Exception {

        if (null == preorder || null == inorder || preorder.length <= 0 || inorder.length <= 0) {
            return null;
        }
        if (preorder.length != inorder.length) {
            throw new Exception("length is not equal, error input");
        }
        boolean flag = false;
        BTreeNode root = new BTreeNode();
        for (int i = 0; i < preorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                flag = true;
                root.data = inorder[i];
                root.leftChild = construct(Arrays.copyOfRange(preorder, 1, i + 1)
                        , Arrays.copyOfRange(inorder, 0, i));
                root.rightChild = construct(Arrays.copyOfRange(preorder, i + 1, preorder.length)
                        , Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        if (!flag) {
            throw new Exception("no root node, error input");
        }
        return root;
    }

    public static void main(String[] args) throws Exception {
        ConstructBTree cb = new ConstructBTree();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        BTreeNode root = cb.construct(pre, in);
        System.out.println(root.data);
    }
}
