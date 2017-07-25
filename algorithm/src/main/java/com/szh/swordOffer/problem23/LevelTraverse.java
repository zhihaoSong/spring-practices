package com.szh.swordOffer.problem23;


import com.szh.offer1.Day04;
import com.szh.swordOffer.BTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 */
public class LevelTraverse {
    public void levelTraverse(BTreeNode root) {
        if (null == root) {
            return;
        }

        Queue<BTreeNode> queue = new LinkedList<BTreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BTreeNode node = queue.poll();
            System.out.println(node.data);
            if (null != node.leftChild) {
                queue.offer(node.leftChild);
            }
            if (null != node.rightChild) {
                queue.offer(node.rightChild);
            }
        }
    }
}
