package com.easy.c06_dynamic_programming;

/**
 * @Author:
 * @Date: 2020-10-08 14:26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
70. 爬楼梯
假设你正在爬楼梯。需要 n阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：
    输入： 2
    输出： 2
    解释： 有两种方法可以爬到楼顶。
    1.  1 阶 + 1 阶
    2.  2 阶

示例 2：
    输入： 3
    输出： 3
    解释： 有三种方法可以爬到楼顶。
    1.  1 阶 + 1 阶 + 1 阶
    2.  1 阶 + 2 阶
    3.  2 阶 + 1 阶

 */
public class C01 {
    public static void main(String[] args) {
        C01 c01 = new C01();
        System.out.println(c01.climbStairs(1));
        System.out.println(c01.climbStairs(2));
        System.out.println(c01.climbStairs(3));
        System.out.println(c01.climbStairs(4));
        System.out.println(c01.climbStairs(5));
        System.out.println(c01.climbStairs(30));
        System.out.println(c01.climbStairs(50));
    }

    public int climbStairs2(int n) {
        if (n == 2) return 2;
        if (n == 1) return 1;

        return climbStairs2(n-1) + climbStairs2(n-2);
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int climbStairs(int n) {
        if (n == 2) return 2;
        if (n == 1) return 1;

        int prevStep = 2;
        int prevPrevStep = 1;

        for (int i = 3; i <= n; i++) {
            int temp = prevStep;
            prevStep = prevStep + prevPrevStep;
            prevPrevStep = temp;
        }

        return prevStep;
    }
}
