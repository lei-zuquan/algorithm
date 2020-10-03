package com.leetcode.soulation.c800;

// 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
//
//注意：如果对空文本输入退格字符，文本继续为空。

import java.util.Stack;

/*
示例 1：

输入：S = "ab#c", T = "ad#c"
输出：true
解释：S 和 T 都会变成 “ac”。
示例 2：

输入：S = "ab##", T = "c#d#"
输出：true
解释：S 和 T 都会变成 “”。
示例 3：

输入：S = "a##c", T = "#a#c"
输出：true
解释：S 和 T 都会变成 “c”。
示例 4：

输入：S = "a#c", T = "b"
输出：false
解释：S 会变成 “c”，但 T 仍然是 “b”

提示：

1 <= S.length <= 200
1 <= T.length <= 200
S 和 T 只含有小写字母以及字符 '#'。

进阶：

你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？

 */
public class C844 {
    public static void main(String[] args) {
        C844 c844 = new C844();
        System.out.println(c844.backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(c844.backspaceCompare("ab##", "c#d#")); // true
        System.out.println(c844.backspaceCompare("a##c", "#a#c")); // true
        System.out.println(c844.backspaceCompare("a#c", "b"));     // false
        System.out.println(c844.backspaceCompare("", "1"));     // false
    }

    // 如果遇到 # 就需要将最后一个元素弹出，就是典型的后进先出，可以使用栈数据结构来做辅助
    public boolean backspaceCompare(String S, String T) {
        Stack stack1 = getFinalValue(S);
        Stack stack2 = getFinalValue(T);

        String s1 = stack1.toString();
        String s2 = stack2.toString();
        if (s1.equals(s2)) {
            return true;
        }
        return false;
    }

    // 将公共代码进行封装成公共方法
    private Stack getFinalValue(String value) {
        char[] arr = value.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            char curr = arr[i];
            if (curr == '#') {
                if (stack.size() > 0) stack.pop();
            } else {
                stack.push(curr);
            }
        }

        return stack;
    }
}
