package com.offer;

/**
 * @Author:
 * @Date: 2020-11-01 21:49
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。


首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，
作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，
那么其数值范围为[−231, 231− 1]。如果数值超过这个范围，请返回 INT_MAX (231− 1) 或INT_MIN (−231) 。

示例1:
输入: "42"
输出: 42

示例2:
输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
    我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

示例3:
输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。

示例4:
输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。

示例5:
输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
    因此返回 INT_MIN (−231) 。

 */
public class C12 {
    public static void main(String[] args) {
        C12 c12 = new C12();
        System.out.println(c12.strToInt("42"));
        System.out.println(c12.strToInt("   -42"));
        System.out.println(c12.strToInt("4193 with words"));
        System.out.println(c12.strToInt("words and 987"));
        System.out.println(c12.strToInt("-91283472332"));
        System.out.println(c12.strToInt("999999999999999999999"));
        System.out.println(c12.strToInt("+-2"));
        System.out.println(c12.strToInt("2147483648"));
        System.out.println(c12.strToInt(" ++1"));
    }

    // 遍历法
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int strToInt2(String str) {
        // 去除首尾空格
        String trim = str.trim();
        char[] chars = trim.toCharArray();
        boolean isNeg = false;
        boolean isPlus = false;
        boolean haveNum = false;
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-') {
                if (haveNum) break;
                if (isPlus) break;
                if (isNeg) break;
                isNeg = true;
                continue;
            }
            if (chars[i] == '+') {
                if (haveNum) break;
                if (isNeg) break;
                if (isPlus) break;
                isPlus = true;
                continue;
            }

            if (chars[i] >= '0' && chars[i] <= '9') {
                int plusNum = Integer.parseInt(chars[i] + "");
                if (res > (Integer.MAX_VALUE - plusNum) / 10) {
                    if (isNeg) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                res = res * 10 + plusNum;
                haveNum = true;
                continue;
            }

            break;
        }

        if (isNeg) {
            res = res * -1;
        }

        return res;
    }

    public int strToInt(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if(length == 0) return 0;
        while(str.charAt(i) == ' ')
            if(++i == length) return 0;
        if(str.charAt(i) == '-') sign = -1;
        if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        for(int j = i; j < length; j++) {
            if(str.charAt(j) < '0' || str.charAt(j) > '9') break;
            if(res > bndry || res == bndry && str.charAt(j) > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (str.charAt(j) - '0');
        }
        return sign * res;
    }


}
