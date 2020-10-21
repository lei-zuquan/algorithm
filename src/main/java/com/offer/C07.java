package com.offer;

import java.util.Stack;

/**
 * @Author:
 * @Date: 2020-10-21 18:47
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
剑指 Offer 09. 用两个栈实现队列

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )


示例 1：
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]

示例 2：
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]

提示：
1 <= values <= 10000
最多会对appendTail、deleteHead 进行10000次调用

 */
public class C07 {
    // 队列是先进先出的，后进后出的
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // 双栈法
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public C07() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }


/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

    public static void main(String[] args) {
        C07 c07 = new C07();
        c07.appendTail(1);
        c07.appendTail(2);
        c07.appendTail(3);


        for (int i = 0; i < 10; i++) {
            int res = c07.deleteHead();
            System.out.println(res);
        }
        System.out.println("============================");
        c07.appendTail(4);
        c07.appendTail(5);
        c07.appendTail(6);
        c07.appendTail(7);
        System.out.println("============================");
        for (int i = 0; i < 5; i++) {
            int res = c07.deleteHead();
            System.out.println(res);
        }
        c07.appendTail(8);
        System.out.println("============================");
        for (int i = 0; i < 3; i++) {
            int res = c07.deleteHead();
            System.out.println(res);
        }
    }

}
