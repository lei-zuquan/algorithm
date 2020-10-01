package com.leetcode.soulation;

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
    }

    public int climbStairs(int n) {
        if (n == 6) {
            return 13;
        }
        if (n == 5) {
            return 8;
        }

        if (n == 4) {
            return 5;
        }
        if (n == 3) {
            return 3;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }

        return climbStairs(n-1) + climbStairs(n-2);
    }
}
