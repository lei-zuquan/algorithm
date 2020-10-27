package com.niuke.a01_huawei;

/**
 * @Author:
 * @Date: 2020-10-27 22:55
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C02 {
    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int start = 0;
        int end = a.length-1;
        int res = n+1;
        while (start <= end) {
            int mid = start + (end - start) /2;
            if (a[mid] >= v) {
                res = mid +1;
                end = mid -1;
            } else {
                start = mid+1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        C02 c02 = new C02();
        int i = c02.upper_bound_(10, 2, new int[]{1, 1, 2, 3, 7, 7, 7, 9, 9, 10});
        System.out.println(i);
    }
}
