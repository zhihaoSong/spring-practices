package com.szh.swordOffer;

/**
 * Created by zhihaosong on 17-7-24.
 * 1.二维有序数组查找指定数
 * 数组从左往右，从上往下值依次变大
 */
public class BiArrFind {
    public boolean find(int[][] arr, int number) {
        if (null == arr || arr.length <= 0) {
            return false;
        }
        int row = 0;
        int column = arr[0].length - 1;
        while (column >= 0 && row < arr.length) {
            int current = arr[row][column];
            if (current == number)
                return true;
            else if (current < number) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = new int[4][4];
        a[0][0] = 1;
        a[0][1] = 2;
        a[0][2] = 8;
        a[0][3] = 9;
        a[1][0] = 2;
        a[1][1] = 4;
        a[1][2] = 9;
        a[1][3] = 12;
        a[2][0] = 4;
        a[2][1] = 7;
        a[2][2] = 10;
        a[2][3] = 13;
        a[3][0] = 6;
        a[3][1] = 8;
        a[3][2] = 11;
        a[3][3] = 15;
        System.out.println(new BiArrFind().find(a, 7));
    }
}
