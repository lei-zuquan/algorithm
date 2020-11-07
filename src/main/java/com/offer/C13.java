package com.offer;

/**
 * @Author:
 * @Date: 2020-11-07 17:28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
剑指 Offer 10- I. 斐波那契数列
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

F(0) = 0, F(1)= 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：
输入：n = 2
输出：1

示例 2：
输入：n = 5
输出：5

提示：
0 <= n <= 100
注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/
 */
public class C13 {
    public static void main(String[] args) {
        C13 c13 = new C13();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " --> \t\t" + c13.fib(i));
        }


        System.out.println(48 + " --> \t\t" + c13.fib(48));

        System.out.println(1000000006 + " --> \t\t" + c13.fib(1000000006));
        System.out.println(1000000007 + " --> \t\t" + c13.fib(1000000007));
        System.out.println(1000000008 + " --> \t\t" + c13.fib(1000000008));
    }

    /*
        0   0
        1   1
        2   1
        3   2
        4   3
        5   5
        6   8
        7   13
        8   21
        9   34
        10  56
     */
    // 迭代法
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev1 = 0;
        int prev2 = 1;
        for (int i = 1; i < n; i++) {
            int temp = (prev1 + prev2) % 1_000_000_007;
            prev1 = prev2;
            prev2 = temp;
        }

        return prev2;// % (1_000_000_007);
    }
}
