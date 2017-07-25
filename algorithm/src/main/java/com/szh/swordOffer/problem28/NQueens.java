package com.szh.swordOffer.problem28;

public class NQueens {

	private int n;
	private int[] cols;
	private int sum;

	public NQueens() {
		this.cols = new int[13];
		this.sum = 0;
	}

	public void Nqueens(int n) {
		this.n = n;
		recursiveBacktrack(1);
		System.out.println("放置方式共：" + sum + "种");
	}

	private void recursiveBacktrack(int k) {
		if (k > n) {
			sum++;
			System.out.println("第" + sum + "种方法");
			for (int i = 1; i <= n; i++) {
				System.out.print(i + "行" + cols[i] + "列"+",");
			}
			System.out.println();

		} else {
			for (int i = 1; i <= n; i++) {
				cols[k] = i;
				if (place(k)) {
					recursiveBacktrack(k + 1);
				}
			}
		}
	}

	private boolean place(int k) {
		for (int j = 1; j < k; j++) {
			if (cols[j] == cols[k] || Math.abs(cols[j] - cols[k]) == Math.abs(j - k)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		new NQueens().Nqueens(8);
	}
}
