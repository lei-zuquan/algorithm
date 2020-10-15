package com.easy.c02_string;

/**
 * @Author:
 * @Date: 2020-10-15 16:22
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
125. 验证回文串

给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false

 */
public class C05 {
    public static void main(String[] args) {
        C05 c05 = new C05();
        System.out.println(c05.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(c05.isPalindrome("race a car"));
    }

    // 双指针法
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 1) return true;

        s = s.toLowerCase();
        int start = 0;
        int end = s.length() -1;
        while (start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            boolean startIsValid = (startChar >= 'a' && startChar <= 'z') || (startChar >= '0' && startChar <= '9');
            if (!startIsValid) {
                start++;
                continue;
            }

            boolean endIsValid = (endChar >= 'a' && endChar <= 'z') || (endChar >= '0' && endChar <= '9');
            if (!endIsValid) {
                end--;
                continue;
            }

            if (startChar != endChar) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
