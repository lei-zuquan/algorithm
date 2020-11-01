package com.niuke;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 记录输入字符串数据
        String inputStr = in.nextLine();
        Integer start = in.nextInt();
        Integer end = in.nextInt();

        String res = reverseWords(inputStr, start, end);
        System.out.println(res);
    }

    public static String reverseWords(String s, int start, int end) {
        if (start >= end) return "EMPTY";
        // 无有效单词
        if (s == null) return "EMPTY";
        if (start < 0) return "EMPTY";

        String[] words = s.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) continue;
            list.add(words[i]);
        }

        String[] realWords = new String[list.size()];
        list.toArray(realWords);

        // 只有一个单词
        if (realWords.length == 1) return "EMPTY";
        if (realWords.length <= end) return "EMPTY";

        StringBuilder sb = new StringBuilder();
        // 添加前面的单词
        for (int i = 0; i < start; i++) {
            if (i >= realWords.length) break;
            sb.append(realWords[i]);
            sb.append(" ");
        }
        // 添加反转的单词
        for (int i = end; i >= start; i--) {
            if (i >= realWords.length) break;
            sb.append(realWords[i]);
            sb.append(" ");
        }

        // 添加尾部的单词
        for (int i = end+1; i < realWords.length; i++) {
            if (i >= realWords.length) break;
            sb.append(realWords[i]);
            sb.append(" ");
        }

        String res = sb.toString();
        if (res.length() > 0) {
            res = res.substring(0, res.length() - 1);
        }

        return res;
    }
}
