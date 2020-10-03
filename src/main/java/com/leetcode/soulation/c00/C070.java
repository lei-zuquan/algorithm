package com.leetcode.soulation.c00;

// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//注意：给定 n 是一个正整数。
public class C070 {
    public static void main(String[] args) {
        C070 c070 = new C070();

        System.out.println(c070.climbStairs(1));
        System.out.println(c070.climbStairs(2));
        System.out.println(c070.climbStairs(3));
        System.out.println(c070.climbStairs(4));
        System.out.println(c070.climbStairs(5));
        System.out.println(c070.climbStairs(6));
        System.out.println(c070.climbStairs(44));

        System.out.println("==================================");
        System.out.println(c070.climbStairs2(1));
        System.out.println(c070.climbStairs2(2));
        System.out.println(c070.climbStairs2(3));
        System.out.println(c070.climbStairs2(4));
        System.out.println(c070.climbStairs2(5));
        System.out.println(c070.climbStairs2(6));
        System.out.println(c070.climbStairs2(44));

        System.out.println("==================================");

        System.out.println(c070.climbStairs1(1));
        System.out.println(c070.climbStairs1(2));
        System.out.println(c070.climbStairs1(3));
        System.out.println(c070.climbStairs1(4));
        System.out.println(c070.climbStairs1(5));
        System.out.println(c070.climbStairs1(6));
        System.out.println(c070.climbStairs1(44));
    }

    // 时间复杂度为O(1)
    public int climbStairs1(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int prevStep1 = 2;
        int prevStep2 = 1;
        for (int i = 3; i <= n; i++) {
            int temp = prevStep1 + prevStep2;
            prevStep2 = prevStep1;
            prevStep1 = temp;
        }

        return prevStep1;
    }

    // 递归方式，适用于n比较小的情况，如果N较大，则性能会急剧下降
    // 递归方式：时间复杂度O(n^2)、空间复杂度为O(n)
    public int climbStairs(int n) {
        if (n == 2) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }

        return climbStairs(n-1) + climbStairs(n-2);
    }

    // 改进的递归方法
    // 我们将之前宽过楼梯的进行记忆
    public int climbStairs2(int n) {
        int[] arr = new int[n+1];
        return climbStairs22(n, arr);
    }

    public int climbStairs22(int n, int[] arr) {
        if (arr[n] != 0) return arr[n];

        if (n == 2) {
            arr[2] = 2;
            return 2;
        }
        if (n == 1) {
            arr[1] = 1;
            return 1;
        }

        int ways = climbStairs22(n - 1, arr) + climbStairs22(n - 2, arr);
        arr[n] = ways;
        return ways;
    }


}
