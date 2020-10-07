package com.leetcode.soulation.c00;

/**
 * @Author:
 * @Date: 2020-10-07 9:11
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
67. 二进制求和
给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字1和0。

示例1:
输入: a = "11", b = "1"
输出: "100"

示例2:
输入: a = "1010", b = "1011"
输出: "10101"

提示：
每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。

 */
public class C067 {
    public static void main(String[] args) {
        String a = "1";
        String b = "11"; // 110
        C067 c067 = new C067();
        System.out.println(c067.addBinary(a, b));
    }

    // 迭代法
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public String addBinary(String a, String b) {
        int aStart = a.length()-1;
        int bStart = b.length()-1;
        char aChar;
        char bChar;
        char remainChar = '0';
        StringBuilder sb = new StringBuilder();
        while (aStart >=0 || bStart >= 0) {
            aChar = aStart >= 0 ? a.charAt(aStart--) : '0';
            bChar = bStart >= 0 ? b.charAt(bStart--) : '0';

            boolean b1 = aChar == '1' && bChar == '1' && remainChar == '0';
            boolean b2 = aChar == '1' && bChar == '0' && remainChar == '1';
            boolean b3 = aChar == '0' && bChar == '1' && remainChar == '1';

            boolean b4 = aChar == '1' && bChar == '1' && remainChar == '1';

            boolean b5 = aChar == '0' && bChar == '0' && remainChar == '0';

            if (b1 || b2 || b3) {
                sb.append('0');
                remainChar = '1';
            } else if (b4) {
                sb.append('1');
                remainChar = '1';
            } else if (b5) {
                sb.append('0');
                remainChar = '0';
            } else {
                sb.append('1');
                remainChar = '0';
            }
        }

        if (remainChar == '1') {
            sb.append('1');
        }

        String str = sb.reverse().toString();
        return str;
    }
}
