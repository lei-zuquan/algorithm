package com.leetcode.soulation.c00;

/**
 * @Author:
 * @Date: 2020-10-03 16:18
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设s 的最大长度为 1000。

示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

示例 2：
输入: "cbbd"
输出: "bb"

 */
public class C005 {
    public static void main(String[] args) {
        String value = "aaaaa";
        String resStr = "aaaaa".substring(0, value.length() -1);
        System.out.println(resStr);

        C005 c005 = new C005();
        System.out.println(c005.longestPalindrome("babad"));
        System.out.println(c005.longestPalindrome("cbbd"));
    }

    // 从大到小迭代法
    // 将字符串转成字符数组，从字符串最大的长度依次递减；并判断是否为回文字串；如果不是则整体向后移动；
    // 如果当前循环没有找到最大回文字串，则将遍历的回文字串长度--，继续循环
    // 时间复杂度：O(n^3)
    // 空间复杂度：O(1)
    public String longestPalindrome(String s) {
        char[] allChars = s.toCharArray();
        int size = allChars.length -1;
        for (int currMaxLength = size; currMaxLength >= 0; currMaxLength--) {
            int start = 0;
            int end = currMaxLength;

            while (end <= size) {
                // 记录当前开始位置、结束位置；用于后续将最大回文字串取出
                int startPoint = start;
                int endPoint = end;
                boolean isSame = true;
                // 遍历当前start,end里面的字符串是否对称
                while (startPoint < endPoint) {
                    if (allChars[startPoint] != allChars[endPoint]) {
                        isSame = false;
                        break;
                    }
                    startPoint++;
                    endPoint--;
                }

                // 判断是否找到最长回文子串
                if (isSame) {
                    String resStr = s.substring(start, end+1);
                    return resStr;
                }

                // 如果没有找到当前最大回文子串，双指针整体向后移动
                start++;
                end++;
            }
        }

        return "";
    }
}
