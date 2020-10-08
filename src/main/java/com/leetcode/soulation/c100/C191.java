package com.leetcode.soulation.c100;

/**
 * @Author:
 * @Date: 2020-10-08 15:24
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
191. 位1的个数

编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’的个数（也被称为汉明重量）。

示例 1：
输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。

示例 2：
输入：00000000000000000000000010000000
输出：1
解释：输入的二进制串 00000000000000000000000010000000中，共有一位为 '1'。

示例 3：
输入：11111111111111111111111111111101
输出：31
解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。

提示：

请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的示例 3中，输入表示有符号整数 -3。


进阶:
如果多次调用这个函数，你将如何优化你的算法？

 */
public class C191 {
    public static void main(String[] args) {
        System.out.println("11111111111111111111111111111101".length() -1);
        C191 c01 = new C191();
        System.out.println(c01.hammingWeight(1));
        System.out.println(c01.hammingWeight(2));
        System.out.println(c01.hammingWeight(3));
        System.out.println(c01.hammingWeight(4));

    }

    // 循环和位移动
    // 时间复杂度：O(1)
    // 空间复杂度：O(1)
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) == mask) {
                bits++;
            }
            mask = mask << 1;
        }
        return bits;
    }
}
