package com.easy.string;

/**
 * @Author:
 * @Date: 2020-10-08 9:58
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
public class C01 {
    public static void main(String[] args) {
        C01 c01 = new C01();
        char[] arr1 = new char[]{'h','e','l','l','o'};
        c01.reverseString(arr1);
        c01.println(arr1);

        char[] arr2 = new char[]{'H','a','n','n','a','h'};
        c01.reverseString(arr2);
        c01.println(arr2);


        char[] arr3 = new char[]{'1'};
        c01.reverseString(arr3);
        c01.println(arr3);
    }

    public void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    // 双指针法
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length -1;

        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}
