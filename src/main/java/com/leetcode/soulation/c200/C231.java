package com.leetcode.soulation.c200;

/**
 * @Author:
 * @Date: 2020-10-03 4:01
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
231. 2的幂。给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class C231 {
    public static void main(String[] args) {
        C231 c231 = new C231();
        System.out.println(c231.isPowerOfTwo(1));
        System.out.println(c231.isPowerOfTwo(16));
        System.out.println(c231.isPowerOfTwo(218));
        System.out.println(c231.isPowerOfTwo(0));
        System.out.println(c231.isPowerOfTwo(2));
        System.out.println(c231.isPowerOfTwo(3));
        System.out.println(c231.isPowerOfTwo(4));
    }

    /*
     位运算法：(x & (x-1)) ==0

    若 n = 2^x 且 x为自然数（即 nn 为 22 的幂），则一定满足以下条件：
        1、恒有 n & (n - 1) == 0，这是因为：
            n 二进制最高位为 1，其余所有位为 00；
            n−1 二进制最高位为 0，其余所有位为 1；
        2、一定满足 n > 0。
    */
    // 时间复杂度：O(1)
    // 空间复杂度：O(1)
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n-1)) == 0;
    }

    // 递归法：如果n为奇数（除1外）都不是2的幂次；如果n为偶数则继续判断它的一半是否为2的幂次
    // 时间复杂度：O(logN)
    // 空间复杂度：O(1)
    public boolean isPowerOfTwo1(int n) {
        if (n == 2 || n== 1) {
            return true;
        }

        if (n%2 == 1 || n<1) {
            return false;
        }
        return isPowerOfTwo(n/2);
    }
}
