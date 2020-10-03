package com.leetcode.soulation.c300;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @Author:
 * @Date: 2020-10-03 14:27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
344. 反转字符串
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

示例 1：
输入：["h","e","l","l","o"]
输出：["o","l","l","e","h"]

示例 2：
输入：["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]
 */
public class C344 {
    public static void main(String[] args) {
        C344 c344 = new C344();
        char[] chars1 = {'h', 'e', 'l', 'l', 'o'};
        c344.reverseString(chars1);
        System.out.println(Arrays.toString(chars1));

        char[] chars2 = {'h','a','n','n','a','H'};
        c344.reverseString(chars2);
        System.out.println(Arrays.toString(chars2));

        char[] chars3 = null;
        c344.reverseString(chars3);
        System.out.println(Arrays.toString(chars3));

        char[] chars4 = {'1'};
        c344.reverseString(chars4);
        System.out.println(Arrays.toString(chars4));
    }

    // 首尾同时向中间逼近法
    // 使用首、尾指针分别指向数组的首、尾两端，并进行首尾元素的交换；
    // 然后首指针++、尾指针--。当首尾指针相遇时，说明已经完成数据的交换了
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }

        int start = 0;
        int end = s.length-1;
        while (start < end) {
            char tempChar = s[end];
            s[end] = s[start];
            s[start] = tempChar;
            start++;
            end--;
        }
    }
}
