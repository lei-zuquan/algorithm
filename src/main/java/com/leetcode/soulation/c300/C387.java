package com.leetcode.soulation.c300;

import java.util.HashMap;

/**
 * @Author:
 * @Date: 2020-10-10 17:39
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
387. 字符串中的第一个唯一字符

给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。


示例：
s = "leetcode"
返回 0

s = "loveleetcode"
返回 2

提示：你可以假定该字符串只包含小写字母。
 */
public class C387 {
    public static void main(String[] args) {
        C387 c03 = new C387();
        System.out.println(c03.firstUniqChar("leetcode"));
        System.out.println(c03.firstUniqChar("loveleetcode"));
        System.out.println(c03.firstUniqChar("zzzabac"));
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
   public int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            } else {
                hashMap.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }


    public int firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean haveCommon = false;
            for (int j = 0; j < chars.length; j++) {
                if (i == j) continue;
                if (chars[i] == chars[j]) {
                    haveCommon = true;
                    break;
                }
            }

            if (!haveCommon) return i;
        }
        return -1;
    }
}
