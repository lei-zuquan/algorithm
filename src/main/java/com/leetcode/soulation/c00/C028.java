package com.leetcode.soulation.c00;

// 实现strStr()函数。
// 给定一个haystack 字符串和一个 needle 字符串，
// 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。

public class C028 {
    public static void main(String[] args) {
        String haystack = "hellolll", needle = "ll";
        String haystack2 = "a", needle2 = "a";

        C028 c028 = new C028();
        int res1 = c028.strStr(haystack, needle);
        System.out.println(res1);
        int res2 = c028.strStr(haystack2, needle2);
        System.out.println(res2);

        String haystack3 = "mississippi", needle3 =  "issip";
        int res3 = c028.strStr(haystack3, needle3);
        System.out.println(res3);
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }

        char[] hayArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();

        int pos = -1; // 代表没有找到匹配
        int fininCnt = 0;
        int index = 0;
        while (index < hayArr.length) {
            if (hayArr[index] == needleArr[fininCnt]) {
                if (pos == -1) {
                    pos = index;
                }

                fininCnt++;
                if (fininCnt == needleArr.length) {
                    break;
                }
            } else {
                if (pos != -1) {
                    index = pos+1;
                    // 如果之前已经找到部分匹配的子串，当前字符串又没有匹配上，则恢复
                    pos = -1;
                    fininCnt = 0;
                    continue;
                }
            }
            index++;
        }

        // 有可能第一个数组遍历完成了，第二个数组继续遍历时没有遍历完成
        // 需要再做一次安全校验
        if (fininCnt != needleArr.length) {
            return -1;
        }

        return pos;
    }
}
