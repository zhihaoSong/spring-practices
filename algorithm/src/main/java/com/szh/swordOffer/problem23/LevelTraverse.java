package com.szh.swordOffer.problem23;

import com.ryan.offer.node.BTreeNode;

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

        Queue<BTreeNode> queue = new LinkedList<>();
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
