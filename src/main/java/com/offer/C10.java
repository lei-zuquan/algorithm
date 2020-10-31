package com.offer;

/**
 * @Author:
 * @Date: 2020-10-31 22:37
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
剑指 Offer 58 - II. 左旋转字符串
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
请定义一个函数实现字符串左旋转操作的功能。
比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。


示例 1：
输入: s = "abcdefg", k = 2
输出:"cdefgab"

示例 2：
输入: s = "lrloseumgh", k = 6
输出:"umghlrlose"

限制：
1 <= k < s.length <= 10000
 */
public class C10 {
    public static void main(String[] args) {
        C10 c10 = new C10();
        System.out.println(c10.reverseLeftWords("abcdefg", 2));
        System.out.println(c10.reverseLeftWords("lrloseumgh", 6));
    }

    // 原地复制法
    // 时间复杂度：O(1)
    // 空间复杂度：O(1)
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        int realLeftReverse = n % length;
        StringBuilder sb = new StringBuilder();
        sb.append(s, realLeftReverse, length);
        sb.append(s, 0, realLeftReverse);
        return sb.toString();
    }
}
