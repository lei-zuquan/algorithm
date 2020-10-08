package com.easy.c07_design;

import java.util.Stack;

/**
 * @Author:
 * @Date: 2020-10-08 14:53
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
155. 最小栈
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop()—— 删除栈顶的元素。
top()—— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。


 */

class StackNode {
    int val;
    int minVal;

    public StackNode(int val, int minVal) {
        this.val = val;
        this.minVal = minVal;
    }
}

public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());    //  --> 返回 0.
        System.out.println(minStack.getMin()); // --> 返回 -2.
    }

    private Stack<StackNode> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
    }

    public void push(int x) {
        if (stack.size() == 0) {
            StackNode node = new StackNode(x, x);
            stack.push(node);
            return;
        }

        StackNode top = stack.peek();
        StackNode stackNode;
        if (x < top.minVal) {
            stackNode = new StackNode(x, x);
        } else {
            stackNode = new StackNode(x, top.minVal);
        }
        stack.push(stackNode);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().minVal;
    }
}
