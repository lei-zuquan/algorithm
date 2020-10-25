package com.offer;

import java.util.Stack;

/**
 * @Author:
 * @Date: 2020-10-25 17:38
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
剑指 Offer 30. 包含 min 函数的栈

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
调用 min、push 及 pop 的时间复杂度都是 O(1)。


示例:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.

提示：
各函数的调用总次数不超过 20000 次

 */

// 定义新的数据结构存储当前值及最小值
// 相当于双栈法
// 时间复杂度：O(1)
// 空间复杂度：O(n)
class Node {
    public int val;
    public int currMin;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, int currMin) {
        this.val = val;
        this.currMin = currMin;
    }
}
public class C09 {

    private Stack<Node> stack;
    /** initialize your data structure here. */
    public C09() {
        stack = new Stack();
    }

    public void push(int x) {
        if (stack.size() > 0) {
            int min = x < min() ? x : min();
            Node node = new Node(x, min);
            stack.push(node);
        } else {
            Node node = new Node(x, x);
            stack.push(node);
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int min() {
        return stack.peek().currMin;
    }


    public static void main(String[] args) {
        C09 minStack = new C09();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());   // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());   //   --> 返回 0.
        System.out.println(minStack.min());   // --> 返回 -2.
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
