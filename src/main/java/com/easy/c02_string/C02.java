package com.easy.c02_string;

/**
 * @Author:
 * @Date: 2020-10-08 10:08
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
7. 整数反转

给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例1:
输入: 123
输出: 321

示例 2:
输入: -123
输出: -321

示例 3:
输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为[−231, 231− 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

 */
public class C02 {
    public static void main(String[] args) {
        C02 c02 = new C02();
        System.out.println(c02.reverse(123)); // 321
        System.out.println(c02.reverse(-123)); // -321
        System.out.println(c02.reverse(120)); // 21
        System.out.println(c02.reverse(100)); // 1
        System.out.println(c02.reverse(-100)); // -1
        System.out.println(c02.reverse(2147483602)); // -1
    }

    // 迭代法
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int reverse(int x) {
        boolean isNeg = false;
        if (x < 0) isNeg = true;

        int res = 0;
        if (isNeg) x = -1 * x;

        while (x > 0) {
            int mod = x % 10;
            x = x / 10;
            // 需要考虑整型边界溢出问题
            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = res * 10 + mod;
        }

        if (isNeg) res = res * -1;

        return res;
    }
}
