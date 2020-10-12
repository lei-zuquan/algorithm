package com.leetcode.soulation.c500;

/**
 * @Author:
 * @Date: 2020-10-03 14:45
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
557. 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例：
输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"

提示：
在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

 */
public class C557 {
    public static void main(String[] args) {
        C557 c577 = new C557();
        String word1 = "Let's take LeetCode contest";
        System.out.println(c577.reverseWords(word1));


        StringBuilder sb = new StringBuilder();
        sb.append(new char[]{'1', '2'});
        String s = sb.toString();
        System.out.println(s);
    }

    // 切割单词，对单词进行反转
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public String reverseWords1(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String currWord = words[i];
            // 反转每个单词的字符
            char[] currWordChar = currWord.toCharArray();
            int start = 0;
            int end = currWordChar.length -1;
            while (start < end) {
                char tempChar = currWordChar[end];
                currWordChar[end--] = currWordChar[start];
                currWordChar[start++] = tempChar;
            }

            sb.append(currWordChar);
            sb.append(' ');
        }


        String reverseStr = sb.toString();
        String finalStr = reverseStr.substring(0, reverseStr.length() - 1);
        return finalStr;
    }

    // 原地反转法
    // 将字符串转换成数组，然后识别出新的单词，使用双指针原地进行反转
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public String reverseWords2(String s) {
        char[] allChars = s.toCharArray();
        int wordStart = 0;
        int wordEnd = 0;
        boolean isFoundNewWord = false;
        for (int i = 0; i < allChars.length; i++) {
            if (allChars[i] == ' ') {
                wordEnd = i-1;
                isFoundNewWord = true;
            }
            if (i == (allChars.length -1)) {
                wordEnd = i;
                isFoundNewWord = true;
            }
            // 判断是否找到了新单词
            if (!isFoundNewWord) continue;

            while (wordStart < wordEnd) {
                char temp = allChars[wordStart];
                allChars[wordStart++] = allChars[wordEnd];
                allChars[wordEnd--] = temp;
            }

            wordStart = i+1;
            isFoundNewWord = false;
        }

        String resStr = new String(allChars);
        return resStr;
    }

    public String reverseWords(String s) {
        if(s.length() == 0 || s == null)
            return "";
        String[] words = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(String word : words) {
            sb.append(new StringBuilder(word).reverse().toString() + ' ');
        }
        return sb.delete(sb.length() - 1, sb.length()).toString();
    }
}
