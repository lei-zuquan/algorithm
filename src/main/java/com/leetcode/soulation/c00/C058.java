package com.leetcode.soulation.c00;

/**
 * @Author:
 * @Date: 2020-10-07 8:29
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
58. 最后一个单词的长度
给定一个仅包含大小写字母和空格' '的字符串 s，返回其最后一个单词的长度。
如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

如果不存在最后一个单词，请返回 0。

说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。

示例:
输入: "Hello World"
输出: 5

 */
public class C058 {
    public static void main(String[] args) {
        C058 c058 = new C058();
        System.out.println(c058.lengthOfLastWord("Hello World"));
        System.out.println(c058.lengthOfLastWord("  "));
        System.out.println(c058.lengthOfLastWord("  H  "));
        System.out.println(c058.lengthOfLastWord("Hello World ttt"));

        System.out.println(c058.lengthOfLastWord("a "));
    }

    public int lengthOfLastWord2(String s) {
        if (s.length() == 0) return 0;

        char[] chars = s.toCharArray();
        int lastWordLength = 0;
        for (int i = chars.length-1; i >= 0; i--) {
            if (chars[i] != ' ') {
                lastWordLength++;
            } else {
                if (lastWordLength != 0) {
                    break;
                }
            }
        }
        return lastWordLength;
    }

    // 尾部遍历法
    // 查找最后一个单词长度，从尾部遍历，如果找到有效单词返回即可
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int lengthOfLastWord(String s) {
        int lastWordLength = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                lastWordLength++;
            } else { // 遇到空格，且前面已经记录到遇到有效字符，结束当前循环
                if (lastWordLength != 0) {
                    break;
                }
            }
        }
        return lastWordLength;
    }
}
