package com.offer;


/**
 * @Author:
 * @Date: 2020-10-07 11:14
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
剑指 Offer 05. 替换空格
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：
输入：s = "We are happy."
输出："We%20are%20happy."

限制：
0 <= s 的长度 <= 10000
 */
public class C05 {
    public static void main(String[] args) {
        C05 c05 = new C05();
        System.out.println(c05.replaceSpace("We are happy."));
        System.out.println(c05.replaceSpace("We are happy. "));
        System.out.println(c05.replaceSpace("   "));
    }

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char aChar = s.charAt(i);
            if (aChar == ' ') {
                sb.append("%20");
            } else {
                sb.append(aChar);
            }
        }

        return sb.toString();
    }

    /*
    方法一：字符数组
    由于每次替换从 1 个字符变成 3 个字符，使用字符数组可方便地进行替换。建立字符数组地长度为 s 的长度的 3 倍，这样可保证字符数组可以容纳所有替换后的字符。

    获得 s 的长度 length
    创建字符数组 array，其长度为 length * 3
    初始化 size 为 0，size 表示替换后的字符串的长度
    从左到右遍历字符串 s
    获得 s 的当前字符 c
    如果字符 c 是空格，则令 array[size] = '%'，array[size + 1] = '2'，array[size + 2] = '0'，并将 size 的值加 3
    如果字符 c 不是空格，则令 array[size] = c，并将 size 的值加 1
    遍历结束之后，size 的值等于替换后的字符串的长度，从 array 的前 size 个字符创建新字符串，并返回新字符串
     */
    public String replaceSpace2(String s) {
        int length = s.length();
        char[] chars = new char[length*3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = s.charAt(i);
            }
        }

        String string = new String(chars, 0, size);
        return string;
    }

}
