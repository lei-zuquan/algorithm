package com.offer;

import com.leetcode.soulation.domain.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:
 * @Date: 2020-10-20 18:58
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
剑指 Offer 06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。


示例 1：
输入：head = [1,3,2]
输出：[2,3,1]

限制：

0 <= 链表长度 <= 10000

 */
public class C06 {
    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3, node2);
        ListNode node1 = new ListNode(1, node3);

        C06 c06 = new C06();
        int[] ints = c06.reversePrint(node1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }


    // 栈辅助法
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];

        Stack<ListNode> stack = new Stack<>();
        ListNode currNode = head;
        while (currNode != null) {
            stack.push(currNode);
            currNode = currNode.next;
        }
        int[] ints = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ints[i++] = stack.pop().val;
        }

        return ints;
    }

    // 使用链表辅助法
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int[] reversePrint1(ListNode head) {
        if (head == null) return new int[0];

        List<ListNode> list = new LinkedList<>();
        ListNode currNode = head;
        while (currNode != null) {
            list.add(currNode);
            currNode = currNode.next;
        }

        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(list.size() - 1 - i).val;
        }

        return ints;
    }
}
