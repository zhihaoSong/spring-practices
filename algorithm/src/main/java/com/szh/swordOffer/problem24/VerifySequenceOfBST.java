package com.szh.swordOffer.problem24;

import java.util.Arrays;

/**
 * 二叉搜索树的后序遍历系列
 */
public class VerifySequenceOfBST {
	public boolean verifySequence(int[] sequence) {
		if (null == sequence || sequence.length <= 0) {
			return false;
		}

		int root = sequence[sequence.length - 1];
		
		// BST中左子树结点小于根结点
		int i = 0;
		for (; i < sequence.length - 1; i++) {
			if (sequence[i] > root) {
				break;
			}
		}
		
		// BST中右子树结点大于根结点
		int j = i;
		for (; j < sequence.length - 1; j++) {
			if (sequence[j] < root) {
				return false;
			}
		}

		boolean left = true;
		if (i > 0) {
			left = verifySequence(Arrays.copyOfRange(sequence, 0, i));
		}
		
		
		boolean right = true;
		if (i < sequence.length - 1) {
			right = verifySequence(Arrays.copyOfRange(sequence, i, sequence.length - 1));
		}
		
		return (left && right);
	}
}
