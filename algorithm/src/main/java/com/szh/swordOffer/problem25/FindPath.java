package com.szh.swordOffer.problem25;

import com.ryan.offer.node.BTreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径
 */
public class FindPath {
	public ArrayList<ArrayList<Integer>> findPath(BTreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        Stack<Integer> stack = new Stack<>();
        generate(root, target, stack, list);

        return list;
    }

    private void generate(BTreeNode root, int target, Stack<Integer> stack, ArrayList<ArrayList<Integer>> list) {
        if (null == root) {
            return;
        }
        if (null == root.leftChild && null == root.rightChild) {
            if (root.data == target) {
                ArrayList<Integer> tmpList = new ArrayList<>();
                for (int i : stack) {
                    tmpList.add(i);
                }
                tmpList.add(root.data);
                list.add(tmpList);
            }
        } else {
            stack.push(root.data);
            generate(root.leftChild, target - root.data, stack, list);
            generate(root.rightChild, target - root.data, stack, list);
            stack.pop();
        }
    }
}
