package com.easy.c02_string;

/**
 * @Author:
 * @Date: 2020-10-17 22:18
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
字符串转换整数 (atoi)
请你来实现一个atoi函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：

如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，
则你的函数不需要进行转换，即无法进行有效转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0 。

提示：

本题中的空白字符只包括空格字符 ' ' 。
假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[−231, 231− 1]。
如果数值超过这个范围，请返回 INT_MAX (231− 1) 或INT_MIN (−231) 。


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
public class C06 {
    public static void main(String[] args) {
        C06 c06 = new C06();
        System.out.println(c06.myAtoi("42"));
        System.out.println(c06.myAtoi("   --42"));
        System.out.println(c06.myAtoi("4193 with words"));
        System.out.println(c06.myAtoi("words and 987"));
        System.out.println(c06.myAtoi("-91283472332"));
        System.out.println(c06.myAtoi("99999999999999999"));
        System.out.println(c06.myAtoi("3.14"));
        System.out.println(c06.myAtoi("+1"));
        System.out.println(c06.myAtoi("+-12"));
        System.out.println(c06.myAtoi("00000-42a1234"));
        System.out.println(c06.myAtoi("   +0 123"));
        System.out.println(c06.myAtoi("2147483648"));
        System.out.println(c06.myAtoi("2147483646")); // not ok
    }

    public int myAtoi(String s) {
        boolean haveNeg = false;
        boolean havePlus = false;

        boolean haveFoundNum = false;
        int remain = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (haveFoundNum) break;
                continue;
            }

            if (c == '+') {
                if (haveNeg) return 0;
                if (haveFoundNum) break;
                havePlus = true;
                continue;
            }

            if (c == '-') {
                if (havePlus) return 0;
                if (haveFoundNum) break;
                haveNeg = true;
                continue;
            }
            if (c >= '0' && c<= '9') {
                haveFoundNum = true;
                if (remain >= Integer.MAX_VALUE / 10) {
                    if (haveNeg) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                remain = remain * 10 + Integer.parseInt(c + "");
            } else {
                if (!haveFoundNum) {
                    return 0;
                } else {
                    break;
                }
            }

        }

        if (haveNeg) remain = -1 * remain;

        return remain;
    }
}
