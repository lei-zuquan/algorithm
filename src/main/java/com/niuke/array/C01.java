package com.niuke.array;

/**
 * @Author:
 * @Date: Created in 3:30 下午 2020/10/9
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
请实现有重复数字的有序数组的二分查找。
        输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。

 */
public class C01 {
    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int index = 1;
        for(int i = 0; i<n; i++) {
            if (a[i] < v) {
                index++;
            } else {
                break;
            }
        }
        return index;
    }
}
