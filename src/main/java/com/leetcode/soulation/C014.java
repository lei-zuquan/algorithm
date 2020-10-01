package com.leetcode.soulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Date: 2020-10-01 20:23
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串""。

示例1:
输入: ["flower","flow","flight"]
输出: "fl"

示例2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母a-z。
 */
public class C014 {
    public static void main(String[] args) {
        C014 c014 = new C014();
        String[] strArr1 = {"flower","flow","flight"};
        String commonPrefix = c014.longestCommonPrefix(strArr1);
        System.out.println(commonPrefix);

        System.out.println("===============================");
        String[] strArr2 = {"dog","racecar","car"};
        String commonPrefix2 = c014.longestCommonPrefix(strArr2);
        System.out.println(commonPrefix2);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        List<char[]> list = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            list.add(chars);

            if (chars.length < minLength) {
                minLength = chars.length;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            char curr = list.get(0)[i];;
            for (int index = 1; index < list.size(); index++) {
                if (list.get(index)[i] != curr) {
                    return sb.toString();
                }
            }
            sb.append(curr);
        }

        return sb.toString();
    }
}
