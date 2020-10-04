package com.leetcode.soulation.c00;

/**
 * @Author:
 * @Date: 2020-10-04 14:49
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
69. x 的平方根
实现int sqrt(int x)函数。

计算并返回x的平方根，其中x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:
输入: 4
输出: 2

示例 2:
输入: 8
输出: 2

说明: 8 的平方根是 2.82842...,
    由于返回类型是整数，小数部分将被舍去。

 */
public class C069 {
    public static void main(String[] args) {
        C069 c069 = new C069();
        System.out.println(c069.mySqrt(2147395600));
        System.out.println(c069.mySqrt(0));
        System.out.println(c069.mySqrt(1));
        System.out.println(c069.mySqrt(2));
        System.out.println(c069.mySqrt(3));
        System.out.println(c069.mySqrt(4));
        System.out.println(c069.mySqrt(5));
        System.out.println(c069.mySqrt(6));
        System.out.println(c069.mySqrt(7));
        System.out.println(c069.mySqrt(8));
        System.out.println(c069.mySqrt(9));
        System.out.println(c069.mySqrt(10));
        System.out.println(c069.mySqrt(11));
        System.out.println(c069.mySqrt(12));
        System.out.println(c069.mySqrt(13));
        System.out.println(c069.mySqrt(14));
        System.out.println(c069.mySqrt(15));
        System.out.println(c069.mySqrt(16));
        System.out.println(c069.mySqrt(17));
    }

    // 从小遍历法
    public int mySqrt1(int x) {
        long start = 1;
        while (x >= (start*start)) {
            start++;
        }
        return (int)start-1;
    }

    // 使用库函数法，估记会被怼
    public int mySqrt2(int x) {
        double sqrt = Math.sqrt(x);
        return (int)(sqrt);
    }

    // 二分查找法
    // 时间复杂度：O(logN)
    // 空间复杂度：O(1)
    public int mySqrt(int x) {
        System.out.print(x + " : \t");
        int start = 0;
        int end = x;
        int ans = -1;
        while (start <= end) {
            // 获取中间mid
            int mid = start + (end-start)/2;
            // 不断逼近x，每次记录当前推进的mid值
            if ((long)mid * mid <= x) {
                ans = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return ans;
    }

}
