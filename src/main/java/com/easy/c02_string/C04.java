package com.easy.c02_string;

/**
 * @Author:
 * @Date: 2020-10-15 11:04
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
242. 有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

 */
public class C04 {
    public static void main(String[] args) {
        C04 c04 = new C04();
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(c04.isAnagram(s1, t1));
        System.out.println("=========================");

        String s2 = "rat";
        String t2 = "car";
        System.out.println(c04.isAnagram(s2, t2));

    }

    // 计数法
    // 因为都是小写字母，所以使用数组对字符串字符数量进行计数
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return false; // 两者都为空，不是异位字符串
        if ((s == null && t != null) || (t==null && s != null)) return false; // 两个字符串其中一个为空，表示不同异位字符串
        if (t.length() != s.length()) return false; // 字符串长度不一样，代表不是异位字符串
        if (t.equals(s)) return true; // 如果两个字符串的内容都是一样的，表示两个字符串完全一样

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ++arr[c - 'a'];
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            --arr[c - 'a'];
            if (arr[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
