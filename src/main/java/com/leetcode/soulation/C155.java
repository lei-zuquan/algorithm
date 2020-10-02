package com.leetcode.soulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:
 * @Date: 2020-10-02 11:21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop()—— 删除栈顶的元素。
top()—— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。

 */

class MyNode {
    int val;
    int min;
    MyNode next;

    public MyNode() {
    }

    public MyNode(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

class MinStack {
    private MyNode head = null;


    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        if (head == null) {
            head = new MyNode(x, x);
            return;
        }

        MyNode newNode = new MyNode(x, Math.min(x, head.min));
        newNode.next = head;
        head = newNode;
    }

    public void pop() {
        if (head == null) {
            return;
        }

        MyNode next = this.head.next;
        MyNode oldHead = this.head;
        oldHead.next = null;

        this.head = next;
    }

    public int top() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        return head.val;
    }

    // 时间复杂度为 O(1)
    // 空间复杂度为 O(n)
    public int getMin() {
        return head.min;
    }
}
public class C155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> 返回 0.
        System.out.println(minStack.getMin());   //--> 返回 -2.

    }


}
