package com.leetcode.soulation.c00;

import java.util.Arrays;

/**
 * @Author:
 * @Date: 2020-10-04 11:04
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
public class C066 {
    public static void main(String[] args) {
        C066 c066 = new C066();
        System.out.println(Arrays.toString(c066.plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(c066.plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(c066.plusOne(new int[]{9,9,9})));
    }

    // 数组后续向前遍历法
    // 数组后续遍历，如果当前下标值为9，则进位，该位置为0；如果当前下标值小于9，直接原地++，直接返回
    // 最后需要考虑99、999这种特殊情况，则数组长度扩长1位，首位置1即可
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int[] plusOne(int[] digits) {
        for (int i = digits.length -1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        return newDigits;
    }
}
