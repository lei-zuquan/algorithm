package com.easy.c02_string;

/**
 * @Author:
 * @Date: 2020-10-19 18:32
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
28. 实现 strStr() 【还可以继续优化】
实现strStr()函数。

给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当needle是空字符串时我们应当返回 0 。这与C语言的strstr()以及 Java的indexOf()定义相符。

 */
public class C07 {
    public static void main(String[] args) {
        String hayStack = "hello"; // "mississippi"; //
        String needle = "llo"; // "issipi"; //

        C07 c07 = new C07();
        System.out.println(c07.strStr(hayStack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        // 如果字符串比需要匹配的字符串短，则直接返回-1
        if (haystack.length() < needle.length()) return -1;
        // 如果两个字符串内容完全相同，则直接返回0
        if (haystack.equals(needle)) return 0;

        for (int i = 0; i < haystack.length(); i++) {
            int start = i;
            int pos = 0;
            boolean isFullCommon = true;
            for (int j = 0; j < needle.length(); j++) {
                char c1 = needle.charAt(pos);
                if ((start + pos) >= haystack.length()) return -1;
                char c2 = haystack.charAt(start + pos);

                if (c1 == c2) {
                    pos++;
                } else {
                    isFullCommon = false;
                    break;
                }
            }
            if (isFullCommon) return start;
        }

        return -1;
    }
}
