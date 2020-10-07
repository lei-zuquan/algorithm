package com.leetcode.soulation.c00;

/**
 * @Author:
 * @Date: 2020-10-06 20:29
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
38. 外观数列

给定一个正整数 n（1 ≤n≤ 30），输出外观数列的第 n 项。
注意：整数序列中的每一项将表示为一个字符串。

「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
1.     1
2.     11
3.     21
4.     1211
5.     111221
第一项是数字 1
描述前一项，这个数是 1 即 “一个 1 ”，记作 11
描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 11
描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ”12 ，记作 111221

示例1:
输入: 1
输出: "1"
解释：这是一个基本样例。

示例 2:
输入: 4
输出: "1211"
解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，
也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。

 */
public class C038 {
    public static void main(String[] args) {
        C038 c038 = new C038();
        System.out.println(c038.countAndSay(1));
        System.out.println(c038.countAndSay(2));
        System.out.println(c038.countAndSay(3));
        System.out.println(c038.countAndSay(4));
        System.out.println(c038.countAndSay(5));
        System.out.println(c038.countAndSay(6));
        System.out.println(c038.countAndSay(7));
        System.out.println(c038.countAndSay(8));
        System.out.println(c038.countAndSay(9));
        System.out.println(c038.countAndSay(10));
        System.out.println(c038.countAndSay(11));
        System.out.println(c038.countAndSay(30));
        //System.out.println(c038.countAndSay(50));
    }

    /*
        1.     1
        2.     11
        3.     21
        4.     1211
        5.     111221
     */
    // 迭代法
    // 从1开始，逐步向后取得对应的整数序列
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(n)
    public String countAndSay(int n) {
        System.out.print(n + "\t: ");
        String currNum = "1";

        for (int i = 2; i <= n; i++) {
            //char[] chars = currNum.toCharArray();
            StringBuffer sb = new StringBuffer();
            //sb.delete(0, currNum.length());

            int start = 0;
            char currChar = currNum.charAt(start);
            int length = currNum.length();
            for (int charIndex = 1; charIndex <= length; charIndex++) {

                // 判断是否结束
                if (charIndex == length) {
                    sb.append(charIndex-start).append(currChar);
                    break;
                }
                // 从当前位置向后查找有多少个连续相同的字符
                if (currNum.charAt(charIndex) != currChar) {
                    //sb.append((charIndex - start) + "" + currChar); // 性能较差
                    sb.append(charIndex-start).append(currChar); // 性能较好
                    start = charIndex;
                    currChar = currNum.charAt(start);
                }
            }

            currNum = sb.toString();
        }
        return currNum;
    }


    public String countAndSay3(int n) {
        // 递归终止条件
        if (n == 1) {
            return "1";
        }
        StringBuffer res = new StringBuffer();
        // 拿到上一层的字符串
        String str = countAndSay(n - 1);
        int length = str.length();
        // 开始指针为0
        int start = 0;
        // 注意这从起始条件要和下面长度统一
        for (int i = 1; i < length + 1; i++) {
            // 字符串最后一位直接拼接
            if (i == length) {
                res.append(i - start).append(str.charAt(start));
                // 直到start位的字符串和i位的字符串不同，拼接并更新start位
            } else if (str.charAt(i) != str.charAt(start) ) {
                res.append(i - start).append(str.charAt(start));
                start = i;
            }
        }
        return res.toString();
    }

}


/*





























*/
