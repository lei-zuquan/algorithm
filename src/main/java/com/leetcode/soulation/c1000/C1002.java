package com.leetcode.soulation.c1000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author:
 * @Date: 2020-10-14 18:37
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*

1002. 查找常用字符

给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

你可以按任意顺序返回答案。

示例 1：
输入：["bella","label","roller"]
输出：["e","l","l"]

示例 2：
输入：["cool","lock","cook"]
输出：["c","o"]

提示：
1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] 是小写字母

 */
public class C1002 {
    public static void main(String[] args) {
        C1002 c1002 = new C1002();
        List<String> res1 = c1002.commonChars(new String[]{"bella", "label", "roller"});
        for (int i = 0; i < res1.size(); i++) {
            System.out.print(res1.get(i) + "\t");
        }
        System.out.println("\n===============");

        List<String> res2 = c1002.commonChars(new String[]{"cool","lock","cook"});
        for (int i = 0; i < res2.size(); i++) {
            System.out.print(res2.get(i) + "\t");
        }
        System.out.println("\n===============");
    }


    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0) return null;

        int length = A.length;
        int minIndex = 0;
        for (int i = 1; i < length; i++) {
            if (A[i].length() < minIndex) {
                minIndex = i;
            }
        }

        List<HashMap<Character, Integer>> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (i== minIndex) continue;
            String s = A[i];
            char[] chars = s.toCharArray();
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (int charIndex = 0; charIndex < chars.length; charIndex++) {
                if (hashMap.containsKey(chars[charIndex])) {
                    hashMap.put(chars[charIndex], hashMap.get(chars[charIndex]) +1);
                } else {
                    hashMap.put(chars[charIndex], 1);
                }

            }
            list.add(hashMap);
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < A[minIndex].length(); i++) {
            boolean hashMapFound = true;
            for (int listIndex = 0; listIndex < list.size(); listIndex++) {
                HashMap<Character, Integer> hashMap = list.get(listIndex);
                Integer remainCnt = hashMap.get(A[minIndex].charAt(i));
                if (remainCnt == null || remainCnt <= 0) {
                    hashMapFound = false;
                    break;
                } else {
                    hashMap.put(A[minIndex].charAt(i), hashMap.get(A[minIndex].charAt(i))-1);
                }
            }
            if (hashMapFound) {
                //if (!res.contains(A[minIndex].charAt(i) + "")) {
                    res.add(A[minIndex].charAt(i) + "");
                //}
            }
        }

        return res;
    }
}
