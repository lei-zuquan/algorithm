package com.easy.c01_array;

/**
 * @Author:
 * @Date: 2020-10-11 17:24
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
66. 加一

给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例1:
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。

示例2:
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
 */
public class C07 {
    public static void main(String[] args) {
        C07 c07 = new C07();
        int[] ints = c07.plusOne(new int[]{9, 9, 9});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int[] plusOne(int[] digits) {
        int remain = 1;
        for (int i = digits.length-1; i >=0 ; i--) {
            int sum = digits[i] + remain;
            if (sum < 10) {
                digits[i] = sum;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] newInts = new int[digits.length + 1];
        newInts[0] = 1;
        return newInts;
    }
}
